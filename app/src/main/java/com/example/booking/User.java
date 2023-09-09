package com.example.booking;

import java.io.Serializable;

public class User implements Serializable {
    public String email;
    public String password;
    public UserRole role;

    public User(String email, String password, UserRole role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
