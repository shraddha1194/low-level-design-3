package com.learn.parkinglot.strategies;

import com.learn.parkinglot.models.Ticket;
import org.springframework.stereotype.Service;

@Service
public class SmallFeeCalculationStrategy implements ParkingFeeCalculationStrategy {
    @Override
    public Double calculateParkingFee(Ticket ticket) {
        return null;
    }
}
