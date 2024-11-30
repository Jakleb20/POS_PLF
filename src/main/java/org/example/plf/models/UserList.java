package org.example.plf.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class UserList {
    @Id
    private String id;
    
    
    @JsonProperty("USERS")
    @OneToMany(mappedBy = "userList")
    private List<User> users = new ArrayList<>();    
}
