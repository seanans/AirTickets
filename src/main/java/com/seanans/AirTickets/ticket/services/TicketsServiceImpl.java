package com.seanans.AirTickets.ticket.services;

import com.seanans.AirTickets.ticket.models.CreateFlightDTO;
import com.seanans.AirTickets.ticket.models.TicketDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TicketsServiceImpl implements TicketsService {

    @Override
    public List<TicketDTO> createFlight(CreateFlightDTO flightDTO, int quantityOfSeats) {
        return null;
    }

    @Override
    public HttpStatus deleteTicket(UUID id) {
        return null;
    }

    @Override
    public TicketDTO getTicketById(UUID id) {
        return null;
    }

    @Override
    public List<TicketDTO> getTicketsByFlightNumber(String flightNumber) {
        return null;
    }
}
