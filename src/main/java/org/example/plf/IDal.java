package org.example.plf;

import org.example.plf.models.Location;
import org.example.plf.models.Product;
import org.example.plf.models.User;
import org.example.plf.models.UserList;

import java.util.List;

public interface IDal {
    public void saveUserList(UserList userList);
    public void saveLocation(Location location);
    public Location findLocationByName(String name);
    public void deleteAllUsers();
    public void deleteAllProducts();
    public void deleteAllLocations();
    public int countProductByLocation(Location location);
    User getUserById(String id);

    Product getProductById(String s);
}
