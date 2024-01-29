package com.learn.booking.bookingmanagementsystem.controllers;

import com.learn.booking.bookingmanagementsystem.dtos.CreateCustomerDTO;
import com.learn.booking.bookingmanagementsystem.exceptions.customer.InvalidCustomerException;
import com.learn.booking.bookingmanagementsystem.models.Customer;
import com.learn.booking.bookingmanagementsystem.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    // Get a customer
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    // Create a customer
    @PostMapping
    public Customer createCustomer(@RequestBody CreateCustomerDTO request) {
        // Request validation
        validate(request);
        return customerService.createCustomer(request);
    }

    private void validate(CreateCustomerDTO customerRequest) {
        if (customerRequest.getEmail() == null) {
            throw new InvalidCustomerException();
        }
    }
}
