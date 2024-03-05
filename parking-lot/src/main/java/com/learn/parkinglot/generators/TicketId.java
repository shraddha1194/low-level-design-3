package com.learn.parkinglot.generators;

import java.util.concurrent.atomic.AtomicLong;

public class TicketId {
    private static AtomicLong ticketId = new AtomicLong();

    public static Long nextId() {
        return ticketId.getAndIncrement();
    }
}
