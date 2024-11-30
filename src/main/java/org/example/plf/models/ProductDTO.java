package org.example.plf.models;

import lombok.Data;

// In dieser Klasse werden die Daten von der JSON-Datei eingelesen
@Data
public class ProductDTO {
    
    private String name;
    private String standort;
    private double preis;
}
