package com.learn.parkinglot.models;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class Gate extends BaseModel{
    private String location;
    private ParkingOperator operator;
}
