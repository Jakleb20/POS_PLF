package org.example.plf.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
    private String name;
    
    @OneToMany(mappedBy = "location", cascade = CascadeType.PERSIST)
    private List<Product> products = new ArrayList<>();
    
    
    public Location(String name) {
        this.name = name;
    }

    public Location() {
        
    }
}
