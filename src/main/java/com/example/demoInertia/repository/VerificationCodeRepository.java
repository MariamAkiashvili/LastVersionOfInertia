package com.example.demoInertia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoInertia.model.VerificationCodes;
import java.time.LocalDateTime;

public interface VerificationCodeRepository extends JpaRepository <VerificationCodes, Integer>{
    VerificationCodes findByVerificationCodeAndEmail(String code, String email);
}
