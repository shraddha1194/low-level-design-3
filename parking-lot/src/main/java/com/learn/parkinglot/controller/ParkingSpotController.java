package com.learn.parkinglot.controller;

import com.learn.parkinglot.models.ParkingSpot;
import com.learn.parkinglot.models.VehicleType;
import com.learn.parkinglot.services.ParkingSpotService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parking-spot")
@AllArgsConstructor
public class ParkingSpotController {

    ParkingSpotService parkingSpotService;

    // Find an Available Parking Spot
    @GetMapping("/get-available-spots")
    public List<ParkingSpot> findAvailableParkingSpots(@PathVariable("type") VehicleType type)  {
        return parkingSpotService.findAvailableParkingSpots(type);
    }
}
