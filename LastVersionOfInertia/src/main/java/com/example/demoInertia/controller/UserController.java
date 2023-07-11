package com.example.demoInertia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoInertia.dto.APIResponse;
import com.example.demoInertia.dto.Login;
import com.example.demoInertia.model.User;
import com.example.demoInertia.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/registration")
    public String add(@RequestBody User user){
        userService.saveUser(user);
        return "Registration Completed Successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody Login login){
        userService.login(login);
        return "Logged In Successfully!";
    }

    @GetMapping("/checkEmail")
    public APIResponse usedEmail(@RequestHeader String email){
        return userService.usedEmail(email);

    }
}
