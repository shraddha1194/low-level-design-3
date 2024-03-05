package com.learn.parkinglot.services;

import com.learn.parkinglot.generators.VehicleId;
import com.learn.parkinglot.models.Vehicle;
import com.learn.parkinglot.models.VehicleType;
import com.learn.parkinglot.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleService {

    VehicleRepository vehicleRepository;
    public Vehicle findOrCreateVehicle(String vehicleNumber, VehicleType vehicleType) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleNumber);

        if (vehicle.isPresent()) {
            return vehicle.get();
        }
        Vehicle newVehicle = Vehicle.builder()
                .id(VehicleId.nextId())
                .licenseNumber(vehicleNumber)
                .type(vehicleType)
                .build();

        return vehicleRepository.save(newVehicle);
    }
}
