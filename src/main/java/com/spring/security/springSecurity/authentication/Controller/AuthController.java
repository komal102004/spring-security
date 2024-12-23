package com.spring.security.springSecurity.authentication.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @GetMapping("/")
    public String home()
    {
        return "Welcome to home Page!";
    }
    @RequestMapping("/admin/dashboard")
            public String adminDashboard()
    {
        return "Welcome to the admin Dashboard";
    }
    @RequestMapping("/user/profile")
        public String userProfile()
        {
            return "Welcome to User Profile!";
        }
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "Access-denied!!";
    }



}
