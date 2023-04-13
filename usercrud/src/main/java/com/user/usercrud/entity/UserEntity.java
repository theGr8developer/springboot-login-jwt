package com.user.usercrud.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "userTable")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int Id;
    String name;
    String mobile;
    @OneToOne(cascade = CascadeType.ALL)
    UserAddress address;
    public UserEntity(int id, String name, String mobile, UserAddress address) {
        Id = id;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
    }
    public UserEntity() {
    }
    public void setId(int id) {
        Id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public void setAddress(UserAddress address) {
        this.address = address;
    }
    public int getId() {
        return Id;
    }
    public String getName() {
        return name;
    }
    public String getMobile() {
        return mobile;
    }
    public UserAddress getAddress() {
        return address;
    }    
}
