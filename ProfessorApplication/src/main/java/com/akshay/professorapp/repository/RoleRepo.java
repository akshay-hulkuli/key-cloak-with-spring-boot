package com.akshay.professorapp.repository;

import com.akshay.professorapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
