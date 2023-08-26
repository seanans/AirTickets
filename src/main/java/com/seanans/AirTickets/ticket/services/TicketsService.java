package com.seanans.AirTickets.ticket.services;

import com.seanans.AirTickets.ticket.models.CreateFlightDTO;
import com.seanans.AirTickets.ticket.models.TicketDTO;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;

public interface TicketsService {
    List<TicketDTO> createFlight(CreateFlightDTO flightDTO);

    //TicketDTO orderTicket(Profile profile, String flightNumber);

    HttpStatus deleteTicket(UUID id);

    TicketDTO getTicketById(UUID id);

    List<TicketDTO> getTicketsByFlightNumber(String flightNumber);

    TicketDTO getTicketBySeatNumber(String flightNumber, String seatNumber);
}
