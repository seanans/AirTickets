package com.seanans.AirTickets.user.services;

import com.seanans.AirTickets.ticket.models.TicketDTO;
import com.seanans.AirTickets.user.models.UserRegistrationDTO;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public interface UserService {
    TicketDTO orderTicket(UUID id);

    HttpStatus userRegistration(UserRegistrationDTO userRegistrationDTO);
}
