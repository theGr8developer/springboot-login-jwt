package com.user.userlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.user.userlogin.service.userService;
import com.user.userlogin.entities.*;
import java.util.*;

@RestController
public class userController {

   @Autowired
   private userService userservice;


    @GetMapping("/user")

    public List<User> getMyUser(){
        List<User> list =  userservice.getAllUser();
       list.forEach(user->{System.out.println(user);});
       return list;
    }

    @PostMapping("/user")

    public ResponseEntity<User> createUser(@RequestBody User user,@RequestParam(value="name") String name){
        System.out.println("this create user" + "...."+ name);
       User user1 =  userservice.createUser(user);
       System.out.println(user1);
       return ResponseEntity.status(201).header("data_type","User").body(user1);
    }

    @PutMapping("/user/{id}")
    public User udateUser1(@PathVariable("id") int id, @RequestBody User user){
        User updatedUser = userservice.UpdateUser(id, user);
        return updatedUser;
    }

    @DeleteMapping("/user/{id}")

    public void deleteUser(@PathVariable("id") int id){
        userservice.deleteUser(id);
    }
    
}
