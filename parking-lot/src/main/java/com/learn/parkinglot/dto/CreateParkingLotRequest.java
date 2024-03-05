package com.learn.parkinglot.dto;


import com.learn.parkinglot.exceptions.SomethingWentWrongException;
import com.learn.parkinglot.generators.ParkingFloorId;
import com.learn.parkinglot.generators.ParkingLotId;
import com.learn.parkinglot.generators.ParkingSpotId;
import com.learn.parkinglot.models.*;
import lombok.Getter;

import java.util.ArrayList;
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
    private Integer numberOfFloorsForSmallVehicle;
    private Integer numberOfFloorsForMediumVehicle;
    private Integer numberOfFloorsForLargeVehicle;

    public ParkingLot toParkingLot() {
        if (numberOfFloorsForLargeVehicle + numberOfFloorsForMediumVehicle + numberOfFloorsForSmallVehicle != numberOfFloors) {
            throw new SomethingWentWrongException("The sum of number of floors for each type does not match the total number of floors");
        }
        // Create parking spots and update their ids
        List<ParkingSpot> largeParkingSpots = Collections.nCopies(numberOfSpotsPerFloor, ParkingSpot.mediumAvailable());
        largeParkingSpots.forEach(parkingSpot -> parkingSpot.setSpotId(ParkingSpotId.nextId()));

        List<ParkingSpot> mediumParkingSpots = Collections.nCopies(numberOfSpotsPerFloor, ParkingSpot.mediumAvailable());
        mediumParkingSpots.forEach(parkingSpot -> parkingSpot.setSpotId(ParkingSpotId.nextId()));

        List<ParkingSpot> smallParkingSpots = Collections.nCopies(numberOfSpotsPerFloor, ParkingSpot.mediumAvailable());
        smallParkingSpots.forEach(parkingSpot -> parkingSpot.setSpotId(ParkingSpotId.nextId()));

        // Create parking floors and update their ids
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        parkingFloors.addAll(Collections.nCopies(numberOfFloorsForLargeVehicle,
                ParkingFloor.builder()
                        .spots(largeParkingSpots)
                        .paymentCounter(PaymentCounter.builder().build())
                        .build()));
        parkingFloors.addAll(Collections.nCopies(numberOfFloorsForMediumVehicle,
                ParkingFloor.builder()
                        .spots(largeParkingSpots)
                        .paymentCounter(PaymentCounter.builder().build())
                        .build()));
        parkingFloors.addAll(Collections.nCopies(numberOfFloorsForSmallVehicle,
                ParkingFloor.builder()
                        .spots(largeParkingSpots)
                        .paymentCounter(PaymentCounter.builder().build())
                        .build()));
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
