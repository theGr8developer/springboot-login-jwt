package com.user.userlogin.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserTable")
public class User {
    private
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    
    String Name;
    String Email;
    String Mobile;

    public User(int id, String name, String email, String mobile) {
        this.id = id;
        Name = name;
        Email = email;
        Mobile = mobile;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    





    


}
