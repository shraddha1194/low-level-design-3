package com.learn.booking.bookingmanagementsystem.models;

import com.learn.booking.bookingmanagementsystem.enums.PaymentMethod;
import com.learn.booking.bookingmanagementsystem.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {

    @OneToMany
    private List<Booking> booking;
    private Double amount;

    @Enumerated
    private PaymentMethod paymentMethod;

    @Enumerated
    private PaymentStatus status;
}
