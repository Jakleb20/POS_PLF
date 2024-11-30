package org.example.plf.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    private double price;
    
    @ManyToOne
    private Location location;
    
    public Product() {
        
    }
    
    public Product(String name, double price, Location location) {
        this.name = name;
        this.price = price;
        this.location = location;
    }
}
