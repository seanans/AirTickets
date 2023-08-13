package com.seanans.AirTickets.ticket.services;

import java.util.Random;

public class SeatNumberGenerator {

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    private static String generateSeatNumber() {

        int rowNumber = generateRandomNumber(1, 26); //26 letters in the English alphabet
        int seatNumber = generateRandomNumber(1, 100); //100 seats per row

        char rowChar = (char) ('A' + rowNumber - 1); //Convert rowNumber to character 'A' = 1

        return String.format("%c%02d", rowChar, seatNumber);
    }
}
