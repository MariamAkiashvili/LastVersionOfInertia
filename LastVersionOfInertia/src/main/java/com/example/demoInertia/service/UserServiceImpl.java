package com.example.demoInertia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoInertia.dto.APIResponse;
import com.example.demoInertia.dto.Login;
import com.example.demoInertia.model.User;
import com.example.demoInertia.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public APIResponse login(Login login){
        APIResponse apiResponse = new APIResponse();

        //verify user by given email and password

        User user = userRepository.findOneByEmailIgnoreCaseAndPassword(login.getEmail(),login.getPassword());

        //response
        if(user == null){
            apiResponse.setData("Email or Password is Inccorect");
            apiResponse.setCode(401);
        }else{
            apiResponse.setData("User logged in successfully");
            apiResponse.setCode(200);
            user.setLogged(true);
            userRepository.save(user);
        }
        return apiResponse;
    }
    
    @Override
    public APIResponse usedEmail(String email){
        APIResponse apiResponse = new APIResponse();

        if(userRepository.findOneByEmailIgnoreCase(email) != null){
            //409 conflict with database
            //using already used email in records
            apiResponse.setCode(409);
            apiResponse.setData("Email is already used!");
        }else{
            apiResponse.setCode(200);
        }
        return apiResponse; 
    }
}