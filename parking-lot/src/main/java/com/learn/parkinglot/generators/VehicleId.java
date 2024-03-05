package com.learn.parkinglot.generators;

import java.util.concurrent.atomic.AtomicLong;

public class VehicleId {
    static AtomicLong vehicleId = new AtomicLong();

    public static Long nextId() {
        return vehicleId.getAndIncrement();
    }
}
