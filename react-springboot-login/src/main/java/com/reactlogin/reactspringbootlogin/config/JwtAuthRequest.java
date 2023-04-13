package com.reactlogin.reactspringbootlogin.config;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class JwtAuthRequest {

    private String username;
    private String password;
    
}
