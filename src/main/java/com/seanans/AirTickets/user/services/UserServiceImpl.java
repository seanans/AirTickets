package com.seanans.AirTickets.user.services;

import com.seanans.AirTickets.exception.ResourceBadRequestException;
import com.seanans.AirTickets.user.mappers.UserMapper;
import com.seanans.AirTickets.user.repository.UserRepository;
import com.seanans.AirTickets.ticket.models.TicketDTO;
import com.seanans.AirTickets.ticket.services.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private static final String UUID_IS_REQUIRED = "UUID is required";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TicketsService ticketsService;

    @Override
    public TicketDTO orderTicket(UUID id) {
        if (id == null) {
            throw new ResourceBadRequestException(UUID_IS_REQUIRED);
        }
        TicketDTO ticketDTO = ticketsService.getTicketById(id);


        return null;
    }
}
