package com.user.usercrud.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginData {
    @NotBlank(message = "username is blank")
    @Size(min=2,max=20,message="size not match")
    String username;
    String email;
    public LoginData(String username, String email) {
        this.username = username;
        this.email = email;
    }
    public LoginData() {
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    @Override
    public String toString() {
        return "LoginData [username=" + username + ", email=" + email + "]";
    }

    




}
