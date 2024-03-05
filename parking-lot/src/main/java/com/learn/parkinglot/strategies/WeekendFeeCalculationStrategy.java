package com.learn.parkinglot.strategies;

import com.learn.parkinglot.models.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class MediumFeeCalculationStrategy implements ParkingFeeCalculationStrategy {

    private final Double baseFee = 80.00;
    private final Double
    @Override
    public Double calculateParkingFee(Ticket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime currentTime = LocalDateTime.now();
        Long hours = entryTime.until(currentTime, ChronoUnit.HOURS);

    }
}
