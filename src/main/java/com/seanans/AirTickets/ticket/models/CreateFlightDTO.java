package com.seanans.AirTickets.ticket.models;

import java.time.LocalDateTime;

public class CreateFlightDTO {
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String boardingGate;
    private String ticketClass;
    private double baseFare;
    private double taxes;
    private double totalCost;
}
