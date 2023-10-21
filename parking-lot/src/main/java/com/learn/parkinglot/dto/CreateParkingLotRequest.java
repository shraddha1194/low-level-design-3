package com.learn.parkinglot.dto;


import com.learn.parkinglot.generators.ParkingFloorId;
import com.learn.parkinglot.generators.ParkingLotId;
import com.learn.parkinglot.generators.ParkingSpotId;
import com.learn.parkinglot.models.*;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class CreateParkingLotRequest {
    private String name;
    private String address;
    private Integer numberOfFloors;
    private Integer numberOfEntryGates;
    private Integer numberOfExitGates;
    private Integer numberOfSpotsPerFloor;

    public ParkingLot toParkingLot() {
        // Create dummy parking spots and update their ids
        List<ParkingSpot> parkingSpots = Collections.nCopies(numberOfSpotsPerFloor, ParkingSpot.mediumAvailable());
        parkingSpots.forEach(parkingSpot -> parkingSpot.setSpotId(ParkingSpotId.nextId()));

        // Create dummy parking floors and update their ids
        List<ParkingFloor> parkingFloors = Collections.nCopies(numberOfFloors,
                ParkingFloor.builder()
                        .spots(parkingSpots)
                        .paymentCounter(PaymentCounter.builder().build())
                        .build());
        parkingFloors.forEach(parkingFloor -> parkingFloor.setId(ParkingFloorId.nextId()));

        return ParkingLot.builder()
                .id(ParkingLotId.nextId())
                .name(name)
                .address(address)
                .floors(parkingFloors)
                .entryGates(Collections.nCopies(numberOfEntryGates, EntryGate.builder().build()))
                .exitGates(Collections.nCopies(numberOfExitGates, ExitGate.builder().build()))
                .build();
    }
}
