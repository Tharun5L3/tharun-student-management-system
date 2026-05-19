package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.User;
import com.example.studentmanagement.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class UserController {


    @Autowired
    private UserService service;

    // SIGNUP API
    @PostMapping("/signup")
    public User signup(@RequestBody User user){

        return service.signup(user);
    }

    // LOGIN API
    @PostMapping("/login")
    public String login(@RequestBody User user){

        boolean result = service.login(user);

        if(result){

            return "Login Successful";
        }

        return "Invalid Email or Password";
    }
}