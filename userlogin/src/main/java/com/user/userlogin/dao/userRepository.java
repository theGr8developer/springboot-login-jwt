package com.user.userlogin.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.user.userlogin.entities.*;

@Component
public interface userRepository extends CrudRepository<User,Integer>{
    
}
