package com.learn.booking.bookingmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookingManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingManagementSystemApplication.class, args);
    }

}
