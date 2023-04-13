package com.user.usercrud.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.user.usercrud.entity.*;
import com.user.usercrud.service.*;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

// @RestController
@Controller
public class UserController {

    //1. create user

    @Autowired
    UserService userservice;


    @PostMapping("/post")
 
    public UserEntity CreateUser(@RequestBody UserEntity user){

        System.out.println(user.getName());
        System.out.println(user.getAddress().getId());
        System.out.println(user.getAddress().getPost());
        userservice.AddUser(user);
        
        return user;
    }

    @GetMapping("/about")
    
    // @RequestMapping(value="/about",method=RequestMethod.GET)
    public String aboutController(Model model){

        model.addAttribute("name","md afroz alam");
        model.addAttribute("date",new Date());
        List<String> names= List.of("md afroz alam","faizan","Haidar");
        model.addAttribute("names", names);
        model.addAttribute("user",new LoginData("md afroz alam","mdafrozalam@gmail.com"));
        return "about";
    }

    @PostMapping(value="/about")
    public String postMethodName(@Valid @ModelAttribute("user") LoginData loginData, BindingResult result) {
       
        if(result.hasErrors()){
            System.out.println(result);
            return "about";
            
        }
        // System.out.println(loginData.toString());
        return "about";
    }
    
    
}
