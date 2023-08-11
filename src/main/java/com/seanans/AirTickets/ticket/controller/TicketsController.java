package com.seanans.AirTickets.ticket.controller;

import com.seanans.AirTickets.ticket.services.TicketsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("v1/tickets")
@Api(value = "Users", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Tickets"}, description = "Tickets Controller")
public class TicketsController {
    @Autowired
    private TicketsService ticketsService;
}
