package com.learn.parkinglot.services;

import com.learn.parkinglot.models.ParkingLot;
import com.learn.parkinglot.repositories.ParkingLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParkingLotService {

    private ParkingLotRepository repository;
    private ParkingSpotService parkingSpotService;

    public ParkingLot create(ParkingLot parkingLot) {
        // Call repository to save the created parking lot
        ParkingLot lot = repository.save(parkingLot);
        parkingSpotService.createParkingSpot(parkingLot);
        return lot;
    }
}
