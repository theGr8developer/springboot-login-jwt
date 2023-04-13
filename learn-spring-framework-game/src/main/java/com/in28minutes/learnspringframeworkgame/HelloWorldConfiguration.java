package com.in28minutes.learnspringframeworkgame;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {
    @Bean

    void name(){
        System.out.println("md Afroz alam");
    }
    
}
