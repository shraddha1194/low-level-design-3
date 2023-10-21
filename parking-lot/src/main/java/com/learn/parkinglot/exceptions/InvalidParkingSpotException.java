package com.learn.parkinglot.exceptions;

public class InvalidParkingSpotException extends RuntimeException {
    public InvalidParkingSpotException() {
        super("Trying to access an invalid parking spot. This may not exist in the system.\n +" +
                "Please try again with valid spot.");
    }
}
