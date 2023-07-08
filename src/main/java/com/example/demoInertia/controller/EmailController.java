package com.example.demoInertia.controller;

import org.hibernate.internal.util.ExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoInertia.service.EmailService;

import jakarta.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// import java.util.Random;

@RestController
@RequestMapping("/User")
@CrossOrigin
public class EmailController {
    private final EmailService emailService;
    //private final Map<String, String> verificationCodes = new HashMap<>(); // Temporary storage for verification codes

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendVerificationCode")
    public String sendVerificationCode(@RequestBody String recipientEmail) {
        // String verificationCode = generateVerificationCode();
        //verificationCodes.put(recipientEmail, verificationCode);

        try {
            emailService.sendVerificationCode(recipientEmail);
            return "Verification code sent successfully!";
        } catch (MessagingException e) {
            return "Failed to send verification code. Please try again.";
        }
        
    }

    @GetMapping("/checkVerificationCode")
    public String checkVerificationCode(@RequestParam("code") String code, 
                                        @RequestParam("email") String email,
                                        @RequestParam("time") String time)
    {

        System.out.println(code);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
        if("Verification code sent successfully!" == emailService.checkVerificationCode(code, email, dateTime)){
            return "Successful verification";
        }

        return "Verification Failed";
        
                    
    }

    // private String generateVerificationCode() {
    //     // Generate a random 6-digit verification code
    //     Random random = new Random();
    //     int code = 100000 + random.nextInt(900000);
    //     return String.valueOf(code);
    // }
}
