package com.learn.parkinglot.generators;

import java.util.concurrent.atomic.AtomicLong;

public class ParkingLotId {
    private  static AtomicLong lotId = new AtomicLong();

    public static Long nextId() {
        return lotId.getAndIncrement();
    }
}
