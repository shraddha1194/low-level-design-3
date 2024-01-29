package com.learn.booking.bookingmanagementsystem.models;

import com.learn.booking.bookingmanagementsystem.enums.SeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Builder(toBuilder = true) // allows to create builder out of exiting objects
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShowSeat  extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated
    private SeatStatus status;
}
