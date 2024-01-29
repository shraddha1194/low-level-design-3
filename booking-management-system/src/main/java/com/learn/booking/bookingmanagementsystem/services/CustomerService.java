package com.learn.booking.bookingmanagementsystem.services;

import com.learn.booking.bookingmanagementsystem.dtos.CreateCustomerDTO;
import com.learn.booking.bookingmanagementsystem.exceptions.customer.CustomerAlreadyExistsException;
import com.learn.booking.bookingmanagementsystem.exceptions.customer.CustomerNotFoundException;
import com.learn.booking.bookingmanagementsystem.models.Customer;
import com.learn.booking.bookingmanagementsystem.models.User;
import com.learn.booking.bookingmanagementsystem.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;
    private UserService userService;

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
     }

     public Customer getCustomerInternal(Long id) {
         return customerRepository.findById(id).orElse(null);
     }

    public Customer createCustomer(CreateCustomerDTO request) {
        // Business validation
        // Validate if the email is not present in system
        // If present, throw an error

        String email = request.getEmail();
        Optional<Customer> existingCustomer = customerRepository.findCustomersByEmail(email);
        if (existingCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException(email);
        }

        // Create the user
         User user = userService.createUser(request.getUsername(), request.getPassword());

        // Create the customer
        Customer customer = Customer.builder()
                .city(request.getCity())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .user(user)
                .build();
        return customerRepository.save(customer);
     }
}
