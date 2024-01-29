package com.learn.booking.bookingmanagementsystem.models;

import com.learn.booking.bookingmanagementsystem.enums.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking extends BaseModel {
    @ManyToOne
    private Show show;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<ShowSeat> seats = new ArrayList<>();

    @ManyToMany
    private List<Payment> payments = new ArrayList<>();

    @Enumerated
    private BookingStatus status;
    private Date bookedAt;
    private Double amount;
}

// B1 - 1, 2, 3 - cancelled
// b2 - 2, 3 - confirmed