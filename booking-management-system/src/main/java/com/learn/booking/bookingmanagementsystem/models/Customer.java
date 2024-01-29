package com.learn.booking.bookingmanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Customer extends BaseModel {

    private String fullName;
    private String phoneNumber;
    private String email;
    private String city;

    @OneToOne
    private User user;
}
