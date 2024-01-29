package com.learn.booking.bookingmanagementsystem.controllers;

import com.learn.booking.bookingmanagementsystem.dtos.CreateShowRequestDTO;
import com.learn.booking.bookingmanagementsystem.models.Show;
import com.learn.booking.bookingmanagementsystem.services.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/shows")
@AllArgsConstructor
public class ShowController {

    private ShowService showService;
    @PostMapping
    public Show createShow(@RequestBody CreateShowRequestDTO request) {
        validate(request);
        return showService.createShow(request);
    }

    private void validate(CreateShowRequestDTO request) {
        Date startTime = request.getStartTime();
        if (startTime == null || startTime.before(new Date())) {
            throw new IllegalArgumentException("Invalid start time for show is provided.");
        }
    }

}
