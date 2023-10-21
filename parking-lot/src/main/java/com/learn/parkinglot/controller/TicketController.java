package com.learn.parkinglot.controller;

import com.learn.parkinglot.dto.CreateTicketRequest;
import com.learn.parkinglot.models.Ticket;
import com.learn.parkinglot.services.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ticket")
@AllArgsConstructor
public class TicketController {

    private TicketService ticketService;

    // Create a ticket
    @PostMapping
    public Ticket createTicket(@RequestBody CreateTicketRequest request) {
        // We can have Validation
        // We can have Transformation
        // if you can do the conversion without talking to DB then do it otherwise pass to service class
        return ticketService.createTicket(request);
    }
}
