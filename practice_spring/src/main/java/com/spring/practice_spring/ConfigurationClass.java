package com.spring.practice_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name,int age){

}

@Configuration
public class ConfigurationClass {

    @Bean
    public String name(){
        return "md afroz alam";
    }

    @Bean

    public int age(){
        return 10;
    }

    //Auto wiring by passing parameter

    // @Bean(name="person1")
    // public Person person(String name, int age){
    //     return new Person(name,age);
    // }


    //Auto-wiring by calling beans
    @Bean(name="person1")
    public Person person(){
        return new Person(name(),age());
    }


    
}
