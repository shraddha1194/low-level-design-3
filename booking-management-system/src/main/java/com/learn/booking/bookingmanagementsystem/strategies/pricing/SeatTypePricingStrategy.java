package com.learn.booking.bookingmanagementsystem.strategies.pricing;

import com.learn.booking.bookingmanagementsystem.models.Booking;
import com.learn.booking.bookingmanagementsystem.models.ShowSeat;
import org.springframework.stereotype.Component;

@Component
public class SeatTypePricingStrategy implements PricingStrategy {
    @Override
    public Double calculatePrice(Booking booking) {
        // iterate over show seats
        // for each show seats -> get the price
        // Add the prices
        return booking.getSeats().stream().mapToDouble(SeatTypePricingStrategy::getPrice).sum();
    }

    // Move to database to avoid OCP
    // (theater_id, seat type) -> price
    private static double getPrice(ShowSeat seat) {
        switch (seat.getSeat().getSeatType()) {
            case VIP:
                return 2000.00;
            case PLATINUM:
                return 1000.00;
            case GOLD:
                return 500.00;
            case SILVER:
                return 250.00;
        }
        throw new IllegalArgumentException("Invalid seat type: " + seat.getSeat().getSeatType());
    }
}
