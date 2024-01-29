package com.learn.booking.bookingmanagementsystem.exceptions;

import java.util.List;

public class AlreadyBookedException extends RuntimeException {
    public AlreadyBookedException(List<Long> showSeatsIds) {
        super("Seats already booked: " + showSeatsIds.toString());
    }
}
