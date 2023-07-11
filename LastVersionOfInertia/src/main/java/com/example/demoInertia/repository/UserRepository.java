package com.example.demoInertia.repository;

import com.example.demoInertia.model.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository <User, Integer>{

    User findOneByEmailIgnoreCaseAndPassword(String email, String password);

    User findOneByEmailIgnoreCase(String email);
    
}
