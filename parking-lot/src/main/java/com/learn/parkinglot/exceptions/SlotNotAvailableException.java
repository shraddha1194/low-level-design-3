package com.learn.parkinglot.exceptions;

import com.learn.parkinglot.models.VehicleType;

public class SlotNotAvailableException extends RuntimeException {
    public SlotNotAvailableException(VehicleType vehicleType) {
        super("Slot not found for vehicle type: " + vehicleType);
    }
}
