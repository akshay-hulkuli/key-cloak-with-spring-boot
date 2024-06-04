package com.akshay.keycloakwithspring.service;

import com.akshay.keycloakwithspring.entity.User;
import com.akshay.keycloakwithspring.repository.UserRepo;
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
