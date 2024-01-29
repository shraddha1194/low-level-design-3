package com.learn.booking.bookingmanagementsystem.controllers;

import com.learn.booking.bookingmanagementsystem.dtos.CreateBookingDTO;
import com.learn.booking.bookingmanagementsystem.models.Booking;
import com.learn.booking.bookingmanagementsystem.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/booking")
public class BookingController {

    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody CreateBookingDTO request) {
        return bookingService.createBooking(request);
    }
}
