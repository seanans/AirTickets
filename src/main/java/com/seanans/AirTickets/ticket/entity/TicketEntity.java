package com.seanans.AirTickets.ticket.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID id;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String flightNumber;
    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String departureCity;
    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String arrivalCity;
    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private LocalDateTime departureTime;
    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private LocalDateTime arrivalTime;
    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String boardingGate;
    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String ticketClass;
    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private double baseFare;
    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private double taxes;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private double totalCost;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private boolean isEmpty;

    private String firstName;
    private String lastName;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String seatNumber;

}
