package com.example.demoInertia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.demoInertia.model.VerificationCodes;
import com.example.demoInertia.model.VerificationType;
import com.example.demoInertia.repository.EmailTypeRepository;
import com.example.demoInertia.repository.VerificationCodeRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.util.Random;
import java.time.LocalDateTime;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Autowired
    private VerificationCodeRepository verificationCodeRepository;

    @Autowired
    EmailTypeRepository type;

    @Autowired
    VerificationCodeRepository checkCode; // check if code exist and match passed value;

    public void sendVerificationCode(String recipientEmail) throws MessagingException {

        System.out.println("1");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String verificationCode = generateVerificationCode();

        System.out.println(recipientEmail);
        System.out.println(verificationCode);
        helper.setTo(recipientEmail);
        helper.setSubject("Verification Code");
        helper.setText("Your verification code is: " + verificationCode + " it is active for the next 15 minutes.");

        mailSender.send(message);

        VerificationCodes code = new VerificationCodes();

        code.setEmail(recipientEmail);        
        code.setVerificationType(type.findByType("EMAIL_VERIFICATION"));
        code.setVerificationCode(verificationCode);
        code.setSendDateTime();
        verificationCodeRepository.save(code);



    }

    public String checkVerificationCode(String code, String email, LocalDateTime time){

        // try {
        //     //VerificationType type = 
        //     VerificationCodes codes = checkCode.findByCodeAndEmailAndDateTime(code, email, time);
        //     if(codes.getSendDateTime().plusMinutes(15).isAfter(time) ){
        //         return "Verification code sent successfully!";
        //     }
        //     else {
        //         return "The code is expired already, please try verification again.";
        //     }
        // } catch (MessagingException e) {
        //     return "Verification Code is incorrect.";
        // }
        VerificationCodes codes = checkCode.findByVerificationCodeAndEmail(code, email);
        if(code!=null){
            if(codes.getSendDateTime().plusMinutes(15).isAfter(time)){
                return "Verification code sent successfully!";
            }
            
        }
        
        return "The code is expired already, please try verification again.";
        

    }


    private String generateVerificationCode() {
        // Generate a random 6-digit verification code
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }
}
