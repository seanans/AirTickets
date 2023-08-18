package com.seanans.AirTickets.ticket.services;

import com.seanans.AirTickets.exception.ResourceBadRequestException;
import com.seanans.AirTickets.exception.ResourceNotFoundException;
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
    private static final String TICKET_NOT_FOUND = "Ticket not found";
    private static final String UUID_IS_REQUIRED = "UUID is required";
    private static final String FLIGHT_NUMBER_IS_REQUIRED = "Flight number is required";
    private static final String SEAT_NUMBER_IS_REQUIRED = "Seat number is required";

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
        ticketsRepository.deleteById(id);
        return HttpStatus.ACCEPTED;
    }

    @Override
    public TicketDTO getTicketById(UUID id) {
        if(id == null) {
            throw new ResourceBadRequestException(UUID_IS_REQUIRED);
        }
        TicketEntity ticketEntity = ticketsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(TICKET_NOT_FOUND)
        );
        return ticketMapper.ticketEntityToTicketDTO(ticketEntity);
    }

    @Override
    public List<TicketDTO> getTicketsByFlightNumber(String flightNumber) {
        if (flightNumber.isEmpty()) {
            throw new ResourceBadRequestException(FLIGHT_NUMBER_IS_REQUIRED);
        }
        List<TicketEntity> ticketEntities = ticketsRepository.findByFlightNumber(flightNumber);
        return ticketMapper.ticketEntitiesToTicketDTOs(ticketEntities);
    }
    
    @Override
    public TicketDTO getTicketBySeatNumber(String flightNumber, String seatNumber) {
        if (flightNumber.isEmpty()) {
            throw new ResourceBadRequestException(FLIGHT_NUMBER_IS_REQUIRED);
        }
        if (seatNumber.isEmpty()) {
            throw new ResourceBadRequestException(SEAT_NUMBER_IS_REQUIRED);
        }
        TicketEntity ticketEntity = ticketsRepository.findBySeatNumberAndFlightNumber(flightNumber,seatNumber);
        return ticketMapper.ticketEntityToTicketDTO(ticketEntity);
    }
}
