package com.learn.parkinglot.generators;

import java.util.concurrent.atomic.AtomicLong;

public class ParkingFloorId {
    private  static AtomicLong floorId = new AtomicLong();

    public static Long nextId() {
        return floorId.getAndIncrement();
    }
}
