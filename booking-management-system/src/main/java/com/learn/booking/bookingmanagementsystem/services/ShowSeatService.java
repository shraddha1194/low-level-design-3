package com.learn.booking.bookingmanagementsystem.services;

import com.learn.booking.bookingmanagementsystem.models.ShowSeat;
import com.learn.booking.bookingmanagementsystem.repositories.ShowSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShowSeatService {

    private ShowSeatRepository showSeatRepository;
    public void create(List<ShowSeat> showSeats) {
        showSeatRepository.saveAll(showSeats);
    }

    public List<ShowSeat> getShowSeat(List<Long> showSeatsIds) {
        return showSeatRepository.findAllById(showSeatsIds);
    }

    public void saveAll(List<ShowSeat> lockedSeats) {
        showSeatRepository.saveAll(lockedSeats);
    }
}
