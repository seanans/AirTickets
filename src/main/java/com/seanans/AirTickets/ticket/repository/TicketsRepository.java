package com.seanans.AirTickets.ticket.repository;

import com.seanans.AirTickets.ticket.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketsRepository extends JpaRepository<TicketEntity, UUID> {
}
