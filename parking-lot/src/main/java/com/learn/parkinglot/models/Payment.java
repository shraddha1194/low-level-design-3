package com.learn.parkinglot.models;

public class Payment {
    private Double amount;

    private Long ticketId;
    private Ticket ticket;

    private PaymentType mode;
    private PaymentStatus status;
}
