package com.learn.parkinglot.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.security.cert.CertPathBuilder;
import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@Getter
public class ParkingLot extends BaseModel{
    private String name;
    private String address;
    @Builder.Default
    private List<ParkingFloor> floors = new ArrayList<>();
    @Builder.Default
    private List<Gate> entryGates = new ArrayList<>();
    @Builder.Default
    private List<Gate> exitGates = new ArrayList<>();
    private DisplayBoard displayBoard;
}
