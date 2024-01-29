package com.learn.booking.bookingmanagementsystem.exceptions.movies;

public class InvalidMovieException extends RuntimeException {
    public InvalidMovieException() {
        super("Empty name provided for the movie.");
    }
}
