package com.learn.parkinglot.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class ParkingSpot extends BaseModel {
    private Long spotId;
    private Long floorId;
    private VehicleType vehicleType;
    private SpotStatus spotStatus;

    public static ParkingSpot mediumAvailable() {
        return ParkingSpot.builder()
                .vehicleType(VehicleType.MEDIUM)
                .spotStatus(SpotStatus.AVAILABLE)
                .build();
    }

    public static ParkingSpot largeAvailable() {
        return ParkingSpot.builder()
                .vehicleType(VehicleType.LARGE)
                .spotStatus(SpotStatus.AVAILABLE)
                .build();
    }
}
