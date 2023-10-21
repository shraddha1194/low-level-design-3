package com.learn.parkinglot.models;

import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
public class Invoice extends BaseModel{
    private LocalDateTime exitTime;
    private Double amount;
    private Long ticketId;
    private Ticket ticket;
    private Long paymentId;
    private Payment payment;
}
