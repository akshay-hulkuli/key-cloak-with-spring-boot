package com.akshay.keycloakwithspring.repository;

import com.akshay.keycloakwithspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
