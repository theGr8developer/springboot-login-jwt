package com.jwt.jwtmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(){

        return  ResponseEntity.status(200).header("jwt","this is jwt").body("you are welcome my dear");
    }
    
}
