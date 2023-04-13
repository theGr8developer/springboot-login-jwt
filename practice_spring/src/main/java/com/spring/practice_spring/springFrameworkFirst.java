package com.spring.practice_spring;

import com.spring.practice_spring.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class springFrameworkFirst {

    public static void main(String[] args){


        var context = new AnnotationConfigApplicationContext(ConfigurationClass.class);

        System.out.println(context.getBean("name"));
        // System.out.println(context.getBean("person"));
        
        System.out.println(context.getBean("person1"));
        System.out.println(context.getBean(Person.class));

       
        
    }
    
}
