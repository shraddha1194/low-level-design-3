package com.learn.parkinglot.repositories;

import com.learn.parkinglot.exceptions.InvalidParkingSpotException;
import com.learn.parkinglot.models.ParkingSpot;
import com.learn.parkinglot.models.SpotStatus;
import com.learn.parkinglot.models.VehicleType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ParkingSpotRepository {
    private static List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingSpot save(ParkingSpot spot) {
        parkingSpots.add(spot);
        return spot;
    }
    public List<ParkingSpot> saveAll(List<ParkingSpot> spots) {
        parkingSpots.addAll(spots);
        return spots;
    }

    public ParkingSpot findById(Long id) {
        return parkingSpots.stream()
                .filter(spot -> spot.getId() == id)
                .findFirst().orElse(null);
    }

    public List<ParkingSpot> findAll() {
        return parkingSpots;
    }

    public List<ParkingSpot> findAllByIds(List<Long> ids) {
        return parkingSpots.stream()
                .filter(spots -> ids.contains(spots.getId()))
                .collect(Collectors.toList());
    }

    public ParkingSpot update(ParkingSpot updatedSpot) {
        ParkingSpot existing = parkingSpots.stream()
                .filter(parkingSpot -> parkingSpot.getId() == updatedSpot.getId())
                .findFirst().get();

        if (Objects.isNull(existing)) {
            throw new InvalidParkingSpotException();
        }

        parkingSpots.remove(existing);
        parkingSpots.add(updatedSpot);
        return updatedSpot;
    }

    public ParkingSpot findByVehicleTypeAndStatusAvailable(VehicleType vehicleType) {
        Optional<ParkingSpot> availableSpot = parkingSpots.stream()
                .filter(spot -> spot.getSpotStatus() == SpotStatus.AVAILABLE && spot.getVehicleType() == vehicleType)
                .findFirst();

        if (availableSpot.isPresent()) {
            return availableSpot.get();
        }

        return null;
    }
}
