package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.User;
import com.example.studentmanagement.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    // SIGNUP
    public User signup(User user){

        return repository.save(user);
    }

    // LOGIN
    public boolean login(User user){

        User existingUser =
                repository.findByUsername(user.getUsername());

        if(existingUser != null &&
                existingUser.getPassword().equals(user.getPassword())){

            return true;
        }

        return false;
    }
}