package com.learn.booking.bookingmanagementsystem.strategies.pricing;

import com.learn.booking.bookingmanagementsystem.models.Booking;


public interface PricingStrategy {

    Double calculatePrice(Booking booking);
}
