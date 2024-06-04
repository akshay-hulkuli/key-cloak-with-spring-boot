package com.akshay.professorapp.service;

import com.akshay.professorapp.entity.User;
import com.akshay.professorapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User getByUserName(String username) {
        return userRepo.findByUsername(username);
    }
}
