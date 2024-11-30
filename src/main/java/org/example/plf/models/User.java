package org.example.plf.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @JsonAlias("name1")
    private String name;
    
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate localDate;
    
    @JsonIgnore
    @ManyToOne
    @org.springframework.data.annotation.Transient
    private UserList userList;
    
    
    
}
