package com.learn.booking.bookingmanagementsystem.exceptions.customer;

public class InvalidCustomerException extends RuntimeException {

    public InvalidCustomerException() {
        super("Email is mandatory");
    }
}
