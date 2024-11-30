package org.example.plf;

import org.example.plf.models.Location;
import org.example.plf.models.Product;
import org.example.plf.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class MyRestController {
    
    private final MyService myService;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    
    public MyRestController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("getNumberOfProductsAtTheLocation")
    public String getNumberOfProductsAtTheLocation(@RequestBody Map<String, Object> payload) {
        String name = (String) payload.get("name");
        logger.info("Name = " + name);

        Location location = myService.getLocationByName(name);

        return "" + myService.getNumberOfProductsAtTheLocation(location);
    }
    
    @PostMapping("shoppingChart")
    public String shoppingChart(@RequestBody String csv) {
        String log = "";
        List<String> values = Arrays.stream(csv.split(";")).toList();
        
        double price = 0.0;
        
        User user = myService.getUserById(values.getFirst());
        
        
        for (int i = 1; i < values.size(); i = i + 2) {
            Product product = myService.getProductById(values.get(i));
            
            double productPrice = product.getPrice() * Integer.parseInt(values.get(i + 1));
            price = price + productPrice;
                
            log += product.getName() + " " + product.getPrice() + "*" + values.get(i+1) + " = " + productPrice + "\n";
        }
        
        return log + "Preis für " + user.getName() + " = " + price;
    }

}
