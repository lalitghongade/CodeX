package com.lala.starter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lala.starter.entities.User;
import com.lala.starter.repo.UserRepo;

@Service
public class UserService {

@Autowired
private UserRepo userRepo;
@Autowired
PasswordEncoder passwordEncoder;

public List<User> getUsers(){
    return userRepo.findAll();
}

public User createUser(User user){
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepo.save(user);
}


    
}
