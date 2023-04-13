package com.user.usercrud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserAddress {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    int Id;
    String Village;
    String PoliceStation;
    String Post;
    String District;
    String State;
    int PinCode;
    public UserAddress(int id, String village, String policeStation, String post, String district, String state,
            int pinCode) {
        Id = id;
        Village = village;
        PoliceStation = policeStation;
        Post = post;
        District = district;
        State = state;
        PinCode = pinCode;
    }
    public UserAddress() {
    }
    public int getId() {
        return Id;
    }
    public String getVillage() {
        return Village;
    }
    public String getPoliceStation() {
        return PoliceStation;
    }
    public String getPost() {
        return Post;
    }
    public String getDistrict() {
        return District;
    }
    public String getState() {
        return State;
    }
    public int getPinCode() {
        return PinCode;
    }
    public void setId(int id) {
        Id = id;
    }
    public void setVillage(String village) {
        Village = village;
    }
    public void setPoliceStation(String policeStation) {
        PoliceStation = policeStation;
    }
    public void setPost(String post) {
        Post = post;
    }
    public void setDistrict(String district) {
        District = district;
    }
    public void setState(String state) {
        State = state;
    }
    public void setPinCode(int pinCode) {
        PinCode = pinCode;
    }

    
    
}
