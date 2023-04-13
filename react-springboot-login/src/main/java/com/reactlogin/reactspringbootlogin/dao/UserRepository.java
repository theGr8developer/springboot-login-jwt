package com.reactlogin.reactspringbootlogin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reactlogin.reactspringbootlogin.model.User;


@Repository
public interface UserRepository extends CrudRepository<User,Integer> {



        @Query(value="select * from user where user.email =:email",nativeQuery = true)
       public User getUserByEmail(@Param("email") String email);
   

}
