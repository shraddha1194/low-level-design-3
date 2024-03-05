package com.learn.parkinglot.generators;

import java.util.concurrent.atomic.AtomicLong;

public class ParkingSpotId {

    private static AtomicLong spotId = new AtomicLong();
    public static Long nextId() {
        return spotId.getAndIncrement();
    }
}
