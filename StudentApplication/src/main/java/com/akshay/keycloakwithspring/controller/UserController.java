package com.akshay.keycloakwithspring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableMethodSecurity
public class UserController {

    @GetMapping(value = {"/", "login"})
    public String login(ModelMap modelMap) {
        return "login";
    }

    @GetMapping(value = "/home")
    public String home() {
        return "home";
    }

    @GetMapping(value = "/manage-users")
    @PreAuthorize("hasAuthority('PROFESSOR')")
//    @PreAuthorize("hasAuthority('PROFESSOR') or hasAuthority('USER')")
    public String manageUsers() {
        return "manageStudents";
    }

    @GetMapping(value = "access-denied")
    public String accessDenied() {
        return "accessDenied";
    }
}
