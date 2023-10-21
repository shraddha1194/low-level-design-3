package com.learn.parkinglot.models;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ParkingOperator extends BaseModel{
    private String name;
    private String email;
    private String phoneNumber;
}
