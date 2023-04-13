package com.web.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {
    

    @RequestMapping("/")
    public String Home(){
        System.out.println("this is home page");
        return "home";
    } 
    
    @RequestMapping("/contact")
    public String Contact() {
    	
    	System.out.println("the contact page incorporate");
    	
    	return "contact";
    }
}
