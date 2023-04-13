package com.reactlogin.reactspringbootlogin.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Component
public class User {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String Name;
    private String Email;
    private String password;
    private String role;
}
