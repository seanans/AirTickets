package com.seanans.AirTickets.ticket.mappers;

import com.seanans.AirTickets.ticket.entity.TicketEntity;
import com.seanans.AirTickets.ticket.models.CreateFlightDTO;
import com.seanans.AirTickets.ticket.models.FlightDTO;
import com.seanans.AirTickets.ticket.models.TicketClassDTO;
import com.seanans.AirTickets.ticket.models.TicketDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface TicketMapper {

    TicketEntity FlightDTOAndTicketClassDTOtoTicketEntity(FlightDTO flightDTO, TicketClassDTO ticketClassDTO);

    TicketDTO ticketEntityToTicketDTO(TicketEntity ticketEntity);

    List<TicketDTO> ticketEntitiesToTicketDTOs(List<TicketEntity> ticketEntities);

    FlightDTO createFlightDTOToFlightDTO(CreateFlightDTO createFlightDTO);
}
