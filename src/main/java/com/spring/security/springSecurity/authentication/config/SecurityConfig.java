package com.spring.security.springSecurity.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.
                authorizeHttpRequests(auth->auth
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**").hasAnyRole("USER","ADMIN")
                        .anyRequest().authenticated())
                .formLogin(form->form
                        .loginPage("/login").permitAll())
                .exceptionHandling(ex->ex.accessDeniedPage("/access-denied"))
                .logout(logout->logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"));
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails user1= User.withUsername("user1" )
        .password(passwordEncoder().encode("password1"))
                .roles("USER")
                .build();
        UserDetails user2= User.withUsername("user2")
                .password(passwordEncoder().encode("password2"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

}
