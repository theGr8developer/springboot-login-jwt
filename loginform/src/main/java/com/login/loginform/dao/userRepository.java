package com.login.loginform.dao;
import com.login.loginform.entities.*;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Component;;

@Component
public interface userRepository extends CrudRepository<User,Integer>{
    
}
