package com.seanans.AirTickets.ticket.services;

import com.seanans.AirTickets.exception.ResourceBadRequestException;
import com.seanans.AirTickets.exception.ResourceNotFoundException;
import com.seanans.AirTickets.ticket.entity.TicketEntity;
import com.seanans.AirTickets.ticket.mappers.TicketMapper;
import com.seanans.AirTickets.ticket.models.CreateFlightDTO;
import com.seanans.AirTickets.ticket.models.FlightDTO;
import com.seanans.AirTickets.ticket.models.TicketClassDTO;
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
    public List<TicketDTO> createFlight(CreateFlightDTO createFlightDTO) {
        if (!flightDTOIsValid.isValid(createFlightDTO)) {
            throw new ResourceBadRequestException(BAD_DATA);
        }
        FlightDTO flightDTO = ticketMapper.createFlightDTOToFlightDTO(createFlightDTO);
        List<TicketDTO> ticketDTOList = new ArrayList<>();

        int typesOfSeatsClasses = createFlightDTO.getSeats().size();
        for (int i = 0; i < typesOfSeatsClasses; i++) {
            int seatsOfClass = createFlightDTO.getSeats().get(i).getSeats();
            TicketClassDTO ticketClassDTO = createFlightDTO.getSeats().get(i);
            seatNumberGenerator.initializeGenerator(createFlightDTO.getSeats().get(i).getColumns(), createFlightDTO.getSeats().get(i).getRows());
            for (int k = 0; k < seatsOfClass; k++) {
                TicketEntity ticketEntity = ticketMapper.FlightDTOAndTicketClassDTOtoTicketEntity(flightDTO, ticketClassDTO);
                String seatNumber = seatNumberGenerator.generateUniqueSeatNumber();
                if (seatNumber == null) {
                    throw new ResourceBadRequestException(BAD_DATA);
                } else {
                    ticketEntity.setSeatNumber(seatNumber);
                }
                ticketsRepository.save(ticketEntity);
                ticketDTOList.add(ticketMapper.ticketEntityToTicketDTO(ticketEntity));
            }
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
        if (id == null) {
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
        TicketEntity ticketEntity = ticketsRepository.findBySeatNumberAndFlightNumber(flightNumber, seatNumber);
        return ticketMapper.ticketEntityToTicketDTO(ticketEntity);
    }
}
