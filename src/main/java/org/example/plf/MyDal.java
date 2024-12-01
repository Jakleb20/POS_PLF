package org.example.plf;

import org.example.plf.models.Location;
import org.example.plf.models.Product;
import org.example.plf.models.User;
import org.example.plf.models.UserList;
import org.example.plf.repos.LocationRepository;
import org.example.plf.repos.ProductRepository;
import org.example.plf.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyDal implements IDal{
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public void saveUserList(UserList userList) {
        List<User> users = new ArrayList<>();
        
        
        users = userList.getUsers();
    
        userRepository.saveAll(users);
    }

    @Override
    public void saveLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public Location findLocationByName(String name) {
        return locationRepository.findLocationByName(name);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    @Override
    public void deleteAllLocations() {
        locationRepository.deleteAll();
    }

    @Override
    public int countProductByLocation(Location location) {
        return productRepository.countProductByLocation(location);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.getUserById(Integer.parseInt(id));
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.getProductById(Integer.parseInt(id));
    }

    @Override
    public void saveAllLocations(List<Location> locations) {
        locationRepository.saveAll(locations);
    }

    @Override
    public void saveAllProducts(List<Product> products) {
        productRepository.saveAll(products);
    }
}
