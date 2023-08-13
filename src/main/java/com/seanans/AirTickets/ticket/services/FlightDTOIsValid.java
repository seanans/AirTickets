package com.seanans.AirTickets.ticket.services;

import com.seanans.AirTickets.ticket.models.CreateFlightDTO;
import org.springframework.stereotype.Component;

@Component
public class FlightDTOIsValid {
    private boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }
    private boolean isFlightDTOValid(CreateFlightDTO flightDTO) {
        return flightDTO != null &&
                isNotEmpty(flightDTO.getFlightNumber()) &&
                isNotEmpty(flightDTO.getDepartureCity()) &&
                isNotEmpty(flightDTO.getArrivalCity()) &&
                flightDTO.getDepartureTime() != null &&
                flightDTO.getArrivalTime() != null &&
                isNotEmpty(flightDTO.getBoardingGate()) &&
                isNotEmpty(flightDTO.getTicketClass()) &&
                flightDTO.getBaseFare() >= 0 &&
                flightDTO.getTaxes() >= 0 &&
                flightDTO.getTotalCost() >= 0;
    }

    public boolean isValid(CreateFlightDTO flightDTO) {
        return isFlightDTOValid(flightDTO);
    }
}
