package com.learn.booking.bookingmanagementsystem.dtos;

import com.learn.booking.bookingmanagementsystem.models.ShowSeat;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CreateBookingDTO {
    private Long customerId;
    private Long showId;
    private List<Long> showSeatsIds = new ArrayList<>();
}
