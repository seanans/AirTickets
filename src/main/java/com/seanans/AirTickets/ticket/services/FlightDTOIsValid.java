package com.seanans.AirTickets.ticket.services;

import com.seanans.AirTickets.ticket.models.CreateFlightDTO;
import com.seanans.AirTickets.ticket.models.TicketClassDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightDTOIsValid {

    private boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }

    private boolean isTicketClassDTOValid(TicketClassDTO ticketClassDTO) {
        return ticketClassDTO != null &&
                isNotEmpty(ticketClassDTO.getTicketClass()) &&
                ticketClassDTO.getSeats() > 0 &&
                ticketClassDTO.getBaseFare() >= 0 &&
                ticketClassDTO.getTaxes() >= 0 &&
                ticketClassDTO.getTotalCost() >= 0;
    }

    private boolean isFlightDTOValid(CreateFlightDTO flightDTO) {
        if (flightDTO == null || !isNotEmpty(flightDTO.getFlightNumber()) ||
                !isNotEmpty(flightDTO.getDepartureCity()) ||
                !isNotEmpty(flightDTO.getArrivalCity()) ||
                flightDTO.getDepartureTime() == null ||
                flightDTO.getArrivalTime() == null ||
                !isNotEmpty(flightDTO.getBoardingGate())) {
            return false;
        }

        List<TicketClassDTO> ticketClasses = flightDTO.getSeats();
        if (ticketClasses != null) {
            for (TicketClassDTO ticketClassDTO : ticketClasses) {
                if (!isTicketClassDTOValid(ticketClassDTO)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValid(CreateFlightDTO flightDTO) {
        return isFlightDTOValid(flightDTO);
    }
}
