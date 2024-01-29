package com.learn.booking.bookingmanagementsystem.services;

import com.learn.booking.bookingmanagementsystem.models.Seat;
import com.learn.booking.bookingmanagementsystem.repositories.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeatService {

    private SeatRepository seatRepository;

    public List<Seat> getAll(Long screenId) {
        return seatRepository.findAllByScreen_Id(screenId);
    }
}
