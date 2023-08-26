package com.seanans.AirTickets.ticket.services;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class SeatNumberGenerator {


    private final Set<String> generatedSeatNumbers = new HashSet<>();

    private int localRows = 0;
    private int localColumns = 0;

    private int lastGeneratedColumn = 0;
    private int lastGeneratedRow = 0;


    private String generateSeatNumber(int row, int column) {
        char columnChar = (char) ('A' + column);
        return String.format("%c%02d", columnChar, row);
    }

    private String generateNumber() {
        if (generatedSeatNumbers.contains(generateSeatNumber(lastGeneratedRow, lastGeneratedColumn))) {

            if (lastGeneratedRow + 1 <= localRows) {
                lastGeneratedRow += 1;
                generatedSeatNumbers.add(generateSeatNumber(lastGeneratedRow, lastGeneratedColumn));
                return generateSeatNumber(lastGeneratedRow, lastGeneratedColumn);
            } else {
                lastGeneratedRow = 1;
                if (lastGeneratedColumn + 1 <= localColumns) {
                    lastGeneratedColumn += 1;
                    generatedSeatNumbers.add(generateSeatNumber(lastGeneratedRow, lastGeneratedColumn));
                    return generateSeatNumber(lastGeneratedRow, lastGeneratedColumn);
                } else {
                    return null;
                }
            }

        } else {
            generatedSeatNumbers.add(generateSeatNumber(lastGeneratedRow, lastGeneratedColumn));
            return generateSeatNumber(lastGeneratedRow, lastGeneratedColumn);

        }

    }

    public void initializeGenerator(int columns, int rows) {
        this.localRows = rows;
        this.localColumns = columns;
        this.lastGeneratedRow = 1;
        this.lastGeneratedColumn = 0;
        if (!generatedSeatNumbers.isEmpty()) {
            generatedSeatNumbers.clear();
        }
    }

    public String generateUniqueSeatNumber() {
        return generateNumber();
    }

}
