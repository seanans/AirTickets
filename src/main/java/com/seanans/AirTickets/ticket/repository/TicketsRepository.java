package com.seanans.AirTickets.ticket.repository;

import com.seanans.AirTickets.ticket.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TicketsRepository extends JpaRepository<TicketEntity, UUID> {
    List<TicketEntity> findByFlightNumber(String flightNumber);

    List<TicketEntity> findBySeatNumber(String seatNumber);

    TicketEntity findBySeatNumberAndFlightNumber(String flightNumber, String seatNumber);
}
