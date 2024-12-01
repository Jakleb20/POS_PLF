package org.example.plf;

import org.example.plf.models.Location;
import org.example.plf.models.Product;
import org.example.plf.models.User;
import org.example.plf.models.UserList;

import java.util.List;

public interface IDal {
    void saveUserList(UserList userList);
    void saveLocation(Location location);
    Location findLocationByName(String name);
    void deleteAllUsers();
    void deleteAllProducts();
     void deleteAllLocations();
     int countProductByLocation(Location location);
    User getUserById(String id);
    Product getProductById(String s);
    void saveAllLocations(List<Location> locations);
    void saveAllProducts(List<Product> products);
}
