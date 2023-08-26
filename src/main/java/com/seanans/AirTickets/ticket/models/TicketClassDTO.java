package com.seanans.AirTickets.ticket.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketClassDTO {
    private String ticketClass;
    private int seats;
    private int columns;
    private int rows;
    private double baseFare;
    private double taxes;
    private double totalCost;
}
