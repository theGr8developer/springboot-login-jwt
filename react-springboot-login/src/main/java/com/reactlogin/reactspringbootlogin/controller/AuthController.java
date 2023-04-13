package com.reactlogin.reactspringbootlogin.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactlogin.reactspringbootlogin.config.CustomUserDetailService;
import com.reactlogin.reactspringbootlogin.config.JwtAuthRequest;
import com.reactlogin.reactspringbootlogin.config.JwtAuthResponse;
import com.reactlogin.reactspringbootlogin.config.JwtTokenHelper;

@RestController

@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailService customUserDetailService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request){

        this.authenticate(request.getUsername(),request.getPassword());

        UserDetails userDetails = this.customUserDetailService.loadUserByUsername(request.getUsername());

       String token =  this.jwtTokenHelper.generateToken(userDetails);

       JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
       jwtAuthResponse.setToken(token);

       return ResponseEntity.ok().body(jwtAuthResponse);


    }

    private void authenticate(String username,String password){


        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password, null);
       try{

           this.authenticationManager.authenticate(authenticationToken);
       }
       catch(DisabledException e){
        throw new DisabledException("user authentication disable");

       }
       
    }
    
}
