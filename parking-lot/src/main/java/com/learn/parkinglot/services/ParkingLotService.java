package com.learn.parkinglot.services;

import com.learn.parkinglot.exceptions.NotFoundException;
import com.learn.parkinglot.models.ParkingLot;
import com.learn.parkinglot.repositories.ParkingLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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

    public ParkingLot getParkingLot(Long id) {
        ParkingLot lot = repository.findById(id);
        if (ObjectUtils.isEmpty(lot)) {
            throw new NotFoundException("Parking Lot with id: " + id + " does not exist!");
        }
        return lot;
    }
}
