package com.learn.parkinglot.services;

import com.learn.parkinglot.models.ParkingLot;
import com.learn.parkinglot.models.ParkingSpot;
import com.learn.parkinglot.models.VehicleType;
import com.learn.parkinglot.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParkingSpotService {

    private ParkingSpotRepository parkingSpotRepository;

    public List<ParkingSpot> createParkingSpot(ParkingLot parkingLot) {
        List<ParkingSpot> spots = parkingLot.getFloors().stream()
                .filter(floor -> !floor.getSpots().isEmpty())
                .flatMap(floor -> floor.getSpots().stream())
                .collect(Collectors.toList());

        return parkingSpotRepository.saveAll(spots);
    }

    public ParkingSpot allocate(Long parkingLotId, VehicleType vehicleType) {
        return parkingSpotRepository.findByVehicleTypeAndStatusAvailable(vehicleType);
    }

    public ParkingSpot update(ParkingSpot parkingSpot) {
        return parkingSpotRepository.update(parkingSpot);
    }
}
