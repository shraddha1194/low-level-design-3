package com.learn.parkinglot.controller;

import com.learn.parkinglot.dto.CreateParkingLotRequest;
import com.learn.parkinglot.models.ParkingLot;
import com.learn.parkinglot.services.ParkingLotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

// Step 1 - Add RestController Annotation
// Step 2 - Add Request to common path that would map/bring request to our controller
@RestController
@RequestMapping("/api/v1/parking-lot")
@AllArgsConstructor
public class ParkingLotController {

    private ParkingLotService parkingLotService;
    // Create a parking lot
    // POST

    // 1. Request validation
    // 2. Data transformation
    @PostMapping
    public ParkingLot createParkingLot(@RequestBody CreateParkingLotRequest request) {
        // Can add validation and transform
        ParkingLot parkingLot = request.toParkingLot();
        return parkingLotService.create(parkingLot);
    }

    // GET /api/v1/parking-lot/{id}
    // Step 3 - Add method leve mapping
    // Step 4 - Add path variable to map the
    @GetMapping("/{id}")
    public ParkingLot getParkingLot(@PathVariable("id") Long id) {
        return ParkingLot.builder().id(id).build();
    }

}
