package com.learn.parkinglot.repositories;

import com.learn.parkinglot.models.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class VehicleRepository {
    List<Vehicle> vehicleList = new ArrayList<>();

    public Vehicle save(Vehicle vehicle) {
        vehicleList.add(vehicle);
        return vehicle;
    }

    public Optional<Vehicle> findById(String licenseNumber ) {
        return vehicleList.stream().filter(v -> Objects.equals(licenseNumber, v.getLicenseNumber())).findFirst();
    }
}
