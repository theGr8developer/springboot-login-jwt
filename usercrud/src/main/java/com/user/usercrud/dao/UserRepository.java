package com.user.usercrud.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.user.usercrud.entity.UserEntity;

@Component
public interface UserRepository extends CrudRepository<UserEntity,Integer>{
    
}
