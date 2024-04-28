package com.example.oauth.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseModel{

    private String name;
    private  String email;
    private String password;

    private Boolean isEmailVerified;
    @ManyToMany
    private List<Role> roles;




}
