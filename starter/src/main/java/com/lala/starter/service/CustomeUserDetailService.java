package com.lala.starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lala.starter.entities.User;
import com.lala.starter.repo.UserRepo;
@Service
public class CustomeUserDetailService  implements UserDetailsService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      //load user from database
     User user =  userRepo.findByEmail(username).orElseThrow(() -> new RuntimeException("User Not Found"));
       
      
      return user;
    }
    
}
