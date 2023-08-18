package com.seanans.AirTickets.user.services;

import com.seanans.AirTickets.ticket.models.TicketDTO;

import java.util.UUID;

public interface UserService {
    TicketDTO orderTicket(UUID id);
}
