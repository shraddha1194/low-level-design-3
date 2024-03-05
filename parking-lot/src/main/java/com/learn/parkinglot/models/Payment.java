package com.learn.parkinglot.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Getter
@Setter
public class Payment {
    private Double amount;

    private Long ticketId;
    private Ticket ticket;

    private PaymentType mode;
    private PaymentStatus status;
}
