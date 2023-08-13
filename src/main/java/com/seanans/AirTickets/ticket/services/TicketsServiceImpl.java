package com.seanans.AirTickets.ticket.services;

import com.seanans.AirTickets.exception.ResourceBadRequestException;
import com.seanans.AirTickets.ticket.entity.TicketEntity;
import com.seanans.AirTickets.ticket.mappers.TicketMapper;
import com.seanans.AirTickets.ticket.models.CreateFlightDTO;
import com.seanans.AirTickets.ticket.models.TicketDTO;
import com.seanans.AirTickets.ticket.repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TicketsServiceImpl implements TicketsService {

    private static final String BAD_DATA = "You entered incorrect data, please check again";

    @Autowired
    private TicketsRepository ticketsRepository;

    @Autowired
    private FlightDTOIsValid flightDTOIsValid;
    @Autowired
    private SeatNumberGenerator seatNumberGenerator;
    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public List<TicketDTO> createFlight(CreateFlightDTO flightDTO) {
        if (!flightDTOIsValid.isValid(flightDTO)) {
            throw new ResourceBadRequestException(BAD_DATA);
        }
        int quantityOfSeats = flightDTO.getSeats();
        if (quantityOfSeats <= 0) {
            throw new ResourceBadRequestException(BAD_DATA);
        }
        List<TicketDTO> ticketDTOList = new ArrayList<>();
        for (int i = 0; i < quantityOfSeats; i++) {
            TicketEntity ticketEntity = ticketMapper.createFlightDTOToTicketEntity(flightDTO);
            ticketEntity.setSeatNumber(seatNumberGenerator.generateNumber());
            TicketDTO ticketDTO = ticketMapper.ticketEntityToTicketDTO(ticketEntity);
            ticketDTOList.add(ticketDTO);
            ticketsRepository.save(ticketEntity);
        }
        return ticketDTOList;
    }

    @Override
    public HttpStatus deleteTicket(UUID id) {
        return null;
    }

    @Override
    public TicketDTO getTicketById(UUID id) {
        return null;
    }

    @Override
    public List<TicketDTO> getTicketsByFlightNumber(String flightNumber) {
        return null;
    }
}
