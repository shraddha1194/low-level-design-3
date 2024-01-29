package com.learn.booking.bookingmanagementsystem.models;

import com.learn.booking.bookingmanagementsystem.enums.SeatType;
import com.learn.booking.bookingmanagementsystem.repositories.ScreenRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private Integer rowNo;
    private Integer columnNo;

    @Enumerated // tells this value comes from enum by default is ordinal, ORDINAL meaning VIP - 0, PLATINUM - 1
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name="screen_id")
    private Screen screen;
}
