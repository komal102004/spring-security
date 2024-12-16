package com.spring.security.springSecurity.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails user1= User.withUsername("user1")
        .password(passwordEncoder().encode("password1"))
                .roles("USER")
                .build();
        UserDetails user2= User.withUsername("user2")
                .password(passwordEncoder().encode("password2"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

}
