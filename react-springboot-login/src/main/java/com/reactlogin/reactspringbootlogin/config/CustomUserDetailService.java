package com.reactlogin.reactspringbootlogin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.reactlogin.reactspringbootlogin.dao.UserRepository;
import com.reactlogin.reactspringbootlogin.model.User;

@Service
public class CustomUserDetailService implements UserDetailsService{

    CustomUserDetail customUserDetail;
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub

        User user;

        if(username == null){
            throw new UsernameNotFoundException("username not found");
        }
        else{

             user = userRepository.getUserByEmail(username);
        }


        return new CustomUserDetail(user);
    }
    
    
}
