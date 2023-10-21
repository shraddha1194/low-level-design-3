package com.learn.parkinglot.services;

import com.learn.parkinglot.models.Vehicle;
import com.learn.parkinglot.models.VehicleType;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    public Vehicle findOrCreateVehicle(String vehicleNumber, VehicleType vehicleType) {
        return Vehicle.builder()
                .licenseNumber(vehicleNumber)
                .type(vehicleType)
                .build();
    }
}
