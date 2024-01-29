package com.learn.booking.bookingmanagementsystem.exceptions.customer;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {
        super("Customer with id: " + id + " not found");
    }
}
