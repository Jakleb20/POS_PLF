package org.example.plf;

import org.example.plf.exception.ProductNotFoundException;
import org.example.plf.exception.UserNotFoundException;
import org.example.plf.models.Location;
import org.example.plf.models.Product;
import org.example.plf.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class MyService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private IDal dal;
    
    public int getNumberOfProductsAtTheLocation(Location location) {
        return dal.countProductByLocation(location);
    }

    public Location getLocationByName(String name) {
        Location location = dal.findLocationByName(name);
        if (location == null) {
            throw new ProductNotFoundException("Produkt wurde nicht gefunden");
        }
        return location;
    }

    public User getUserById(String id) {
        User user = dal.getUserById(id);
        if (user == null) {
            throw new UserNotFoundException("Location wurde nicht gefunden");
        }
        return user;
    }

    public Product getProductById(String s) {
        Product product = dal.getProductById(s);
        if (product == null) {
            throw new ProductNotFoundException("Unbekannter Standort" + s);
        }
        return product;
    }
}
