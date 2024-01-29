package com.learn.booking.bookingmanagementsystem.exceptions.customer;

public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException(String email) {
        super("A user with the email: " + email + " already exists.");
    }
}
