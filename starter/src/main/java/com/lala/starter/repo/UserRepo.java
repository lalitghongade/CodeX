package com.lala.starter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lala.starter.entities.User;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> { 
    public Optional<User> findByEmail(String email);
}
