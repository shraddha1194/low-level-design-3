package com.learn.booking.bookingmanagementsystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateCustomerDTO {
    private String fullName;
    private String phoneNumber;
    private String email;
    private String city;
    private String username;
    private String password;
}
