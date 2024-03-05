package com.learn.parkinglot.strategies;

import com.learn.parkinglot.models.Ticket;

public interface ParkingFeeCalculationStrategy {

    public Double calculateParkingFee(Ticket ticket);
}
