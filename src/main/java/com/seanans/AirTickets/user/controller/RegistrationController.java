package com.seanans.AirTickets.user.controller;

import com.seanans.AirTickets.user.models.UserRegistrationDTO;
import com.seanans.AirTickets.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("registration")
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/sign_up")
    private ResponseEntity<String> userRegistrationRequest(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        userService.userRegistration(userRegistrationDTO);
        return ResponseEntity.ok("User registered, try to log in http://localhost:8888/login");
    }

}
