package com.seanans.AirTickets.ticket.mappers;

import com.seanans.AirTickets.ticket.entity.TicketEntity;
import com.seanans.AirTickets.ticket.models.CreateFlightDTO;
import com.seanans.AirTickets.ticket.models.TicketDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface TicketMapper {
    TicketEntity createFlightDTOToTicketEntity(CreateFlightDTO flightDTO);

    TicketDTO ticketEntityToTicketDTO(TicketEntity ticketEntity);

    List<TicketDTO> ticketEntitiesToTicketDTOs(List<TicketEntity> ticketEntities);
}
