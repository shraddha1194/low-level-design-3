package com.learn.booking.bookingmanagementsystem.exceptions.movies;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(String name) {
        super("Movie with name: " + name + " not found.");
    }

}
