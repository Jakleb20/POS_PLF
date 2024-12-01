package org.example.plf;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.plf.models.Location;
import org.example.plf.models.Product;
import org.example.plf.models.ProductDTO;
import org.example.plf.models.UserList;
import org.example.plf.repos.LocationRepository;
import org.example.plf.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ShoppingChartApplication implements ApplicationRunner {
    
    @Value("classpath:users.json")
    private Resource resource1;

    @Value("classpath:products.json")
    private Resource resource2;
    
    @Autowired
    private IDal dal;
    
    private ObjectMapper om;

    public ShoppingChartApplication(ObjectMapper om, IDal dal){
        this.dal = dal;
        this.om = om;
    }

    public static void main(String[] args) {
        SpringApplication.run(ShoppingChartApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        dal.deleteAllUsers();
        dal.deleteAllLocations();
        dal.deleteAllProducts();

        UserList userList = om.readValue(resource1.getFile(), new TypeReference<UserList>() {});
        dal.saveUserList(userList);

        List<ProductDTO> productDTO = om.readValue(resource2.getFile(), new TypeReference<List<ProductDTO>>() {});
        List<Location> locations = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        
        
        productDTO.forEach(p -> {
            boolean isEnthalten = false;

            for (Location l : locations) {
                if (l.getName().equals(p.getName())) {
                    isEnthalten = true;
                    break;
                }
            }
            if (!isEnthalten){
                locations.add(new Location(p.getStandort()));
            }
        });

        for (ProductDTO dto : productDTO) {
            for (Location location1 : locations) {
                if (location1.getName().equals(dto.getStandort())) {
                    // Product zur Location hinzufügen
                    // Durch das cascade = CascadeType.PERSIST in Location wird das Product auch in
                    // der Tabelle product gespeichert
                    location1.getProducts().add(new Product(dto.getName(), dto.getPreis(), location1));
                    break;
                }
            }
        }        
        
        dal.saveAllLocations(locations);
    }
}
