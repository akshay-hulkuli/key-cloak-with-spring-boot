package com.akshay.keycloakwithspring.repository;

import com.akshay.keycloakwithspring.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
