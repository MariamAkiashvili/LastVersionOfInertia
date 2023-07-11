package com.example.demoInertia.service;

import com.example.demoInertia.dto.APIResponse;
import com.example.demoInertia.dto.Login;
import com.example.demoInertia.model.User;

public interface UserService {
    public User saveUser(User user);
    public APIResponse usedEmail(String email);
    public APIResponse login(Login login);
}
