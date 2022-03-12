package com.alkemy.pelicula.pelicula.auth.entity;

import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Enabled(name = "user")
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GerationType.AUTO)
    private  Long id;
    @Email
    private  String username;
    @Size(min = 8)
    private  String password;
    private  boolean accountNonExpired;
    private  boolean accountNonLocked;
    private  boolean credentialsNonExpired;
    private boolean enable;

    public UserEntity(){
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enable = true;
    }
    public  Long getId() { return id; }
    public  void setId(Long id) { this.id = id; }
    @Override
    public String getUsername() { return username; }
    public void setUsername(String username){ this.username = username; }
}

