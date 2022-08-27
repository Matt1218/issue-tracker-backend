package com.welfley.issuetrackerbackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class UserResource {

    @Id
    @GeneratedValue
    private Long id;

//    @Column(name = "username", unique = true)
    private String username;
    private String password;

    public UserResource(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserResource(){
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
