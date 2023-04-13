package com.user.userlogin.service;

import com.user.userlogin.dao.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.userlogin.entities.*;

@Component
public class userService {
 
    @Autowired
   private userRepository userrepository;

    public List<User> getAllUser(){

        List<User> list = (List) userrepository.findAll();
        return list;
    }

    public User createUser(User user){
       user =   userrepository.save(user);
       return user;
    }

    public User UpdateUser(int id, User user){
        Optional<User> user1 = userrepository.findById(id);
        User userUpdate = null;
        if(user1.isPresent()){
           userUpdate = user1.get();
           userUpdate.setName(user.getName());
           userUpdate.setEmail(user.getEmail());
           userUpdate.setMobile(user.getMobile());
        }
        return userUpdate;
    }

    public void deleteUser(int id){
        userrepository.deleteById(id);
    }
}
