package com.learn.parkinglot.controller;

import com.learn.parkinglot.models.ParkingSpot;

public class ParkingSpotController {

    // Create a parking spot
    // POST /parking-spot
    public ParkingSpot createParkingSpot(ParkingSpot parkingSpot) {
        return ParkingSpot.builder().build();
    }

    // Update a parking spot
    // PUT /parking-spot/{id}

    // Get a parking spot
    // GET /parking-spot/{id}
    public ParkingSpot getParkingSpot(Long parkingSpotId) {
        return ParkingSpot.builder().build();
    }
    // Delete a parking spot
    // DELETE /parking-spot/{id}
}
