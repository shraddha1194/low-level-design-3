package com.learn.booking.bookingmanagementsystem.exceptions.movies;

public class MovieAlreadyExistsException extends RuntimeException {
    public MovieAlreadyExistsException(String name) {
        super("Movie with name: " + name + " already exists.");
    }
}
