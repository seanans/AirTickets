package com.seanans.AirTickets.config;

/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/registration/**").permitAll() // Allow registration
                                .requestMatchers("/login").permitAll()    // Allow login
                                .requestMatchers("/admin/**").hasRole("ADMIN") // Only ADMIN can access /admin/**
                                .requestMatchers("/user/**").hasRole("USER")   // Only USER can access /user/**
                                .requestMatchers("v1/tickets/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                );

        return http.build();
    }

}

 */