package com.user.usercrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.user.usercrud.dao.*;
import com.user.usercrud.entity.*;
@Component
public class UserService {

    @Autowired
    UserRepository userrepository;
    
    public void AddUser(UserEntity user){
        UserEntity addedUser=userrepository.save(user);
        System.out.println(addedUser.getAddress().getPost());
    }
}
