package com.learn.parkinglot.models;


import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Date;

@SuperBuilder
public class Ticket extends BaseModel {
    private Long vehicleId;
    private Vehicle vehicle;
    private Long parkingSpotId;
    private ParkingSpot parkingSpot;
    private LocalDateTime entryTime;
    private Gate entryGate;
    private Long entryGateId;
    private ParkingOperator issuedBy;
    private Long issueId;
}
