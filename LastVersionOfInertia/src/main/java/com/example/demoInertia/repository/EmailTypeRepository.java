package com.example.demoInertia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoInertia.model.VerificationType;

@Repository
public interface EmailTypeRepository extends JpaRepository <VerificationType, Integer>{
    public VerificationType findByType(String type);
    
}
