package com.learn.parkinglot.dto;

import com.learn.parkinglot.models.VehicleType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateTicketRequest {
    private Long parkingLotId;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private Long entryGateId;
    private Long issuerId; //Parking operator ID
}
