package com.email.emailweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {


    @RequestMapping("/welcome")
    public String Welcome(){
            return "Welcome my friend";
    }
    
}
