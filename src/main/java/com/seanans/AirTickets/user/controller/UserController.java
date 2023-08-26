package com.seanans.AirTickets.user.controller;

import com.seanans.AirTickets.user.services.UserService;
import com.seanans.AirTickets.ticket.models.TicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{id}")
    private ResponseEntity<TicketDTO> orderTicket(@RequestBody UUID id) {
        return new ResponseEntity<>(userService.orderTicket(id), HttpStatus.ACCEPTED);
    }
}
