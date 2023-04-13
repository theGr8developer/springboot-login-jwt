package com.reactlogin.reactspringbootlogin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.reactlogin.reactspringbootlogin.dao.UserRepository;
import com.reactlogin.reactspringbootlogin.model.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class HomeController {

    @Autowired
    UserRepository userrepository;

    @GetMapping("/home")
    public ResponseEntity<String> Welcome(){

        return ResponseEntity.ok("You Are Welcome");
    }

    @PostMapping("/postuser")
    public ResponseEntity<String> saveUser(@RequestBody User user){
        try{

            user.setRole("ROLE_USER");
            System.out.println("saving user");
            User saveUser = userrepository.save(user);
            System.out.println(saveUser);
        }
        catch(Exception exception){
                exception.printStackTrace();
        }

        return ResponseEntity.ok("save user successfully");
    }

    @GetMapping("/get-all-user")
    public ResponseEntity<List<User>> getAllUser(){

        List<User> allUser = new ArrayList<User>();
        Iterable<User> findAllUser = userrepository.findAll();
        for(User user:findAllUser){
                allUser.add(user);
        }

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(allUser);
    }
    
}
