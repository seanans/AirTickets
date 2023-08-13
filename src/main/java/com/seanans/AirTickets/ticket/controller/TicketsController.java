package com.seanans.AirTickets.ticket.controller;

import com.seanans.AirTickets.ticket.models.CreateFlightDTO;
import com.seanans.AirTickets.ticket.models.TicketDTO;
import com.seanans.AirTickets.ticket.services.TicketsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("v1/tickets")
@Api(value = "Users", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Tickets"}, description = "Tickets Controller")
public class TicketsController {
    @Autowired
    private TicketsService ticketsService;

    @GetMapping("/{id}")
    private ResponseEntity<TicketDTO> getTicketById(@PathVariable UUID id) {
        return new ResponseEntity<>(ticketsService.getTicketById(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{flightNumber}")
    private ResponseEntity<List<TicketDTO>> getTicketsByFlightNumber(@PathVariable String flightNumber) {
        return new ResponseEntity<>(ticketsService.getTicketsByFlightNumber(flightNumber), HttpStatus.ACCEPTED);
    }

    @PostMapping
    private ResponseEntity<List<TicketDTO>> createFlight(@RequestBody CreateFlightDTO flightDTO, int seats) {
        return new ResponseEntity<>(ticketsService.createFlight(flightDTO, seats), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<HttpStatus> deleteTicket(@PathVariable UUID id) {
        return new ResponseEntity<>(ticketsService.deleteTicket(id), HttpStatus.ACCEPTED);
    }

}
