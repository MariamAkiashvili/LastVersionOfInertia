package com.example.demoInertia.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class VerificationCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    @ManyToOne
    private VerificationType verificationType;

    private String verificationCode;

    public VerificationType getVerificationType() {
        return verificationType;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public void setSendDateTime(LocalDateTime sendDateTime) {
        this.sendDateTime = sendDateTime;
    }

    private LocalDateTime sendDateTime;

    public LocalDateTime getSendDateTime() {
        return sendDateTime;
    }

    public void setSendDateTime() {
        this.sendDateTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public VerificationType getverificationType() {
        return verificationType;
    }

    public void setVerificationType(VerificationType emailType) {
        this.verificationType = emailType;
    }
    
}
