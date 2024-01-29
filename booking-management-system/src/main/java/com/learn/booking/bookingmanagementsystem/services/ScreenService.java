package com.learn.booking.bookingmanagementsystem.services;

import com.learn.booking.bookingmanagementsystem.models.Screen;
import com.learn.booking.bookingmanagementsystem.repositories.ScreenRepository;
import org.springframework.stereotype.Service;

@Service
public class ScreenService {

    private ScreenRepository screenRepository;
    public Screen getScreen(Long screenId) {
        return screenRepository.findById(screenId).orElse(null);
    }
}
