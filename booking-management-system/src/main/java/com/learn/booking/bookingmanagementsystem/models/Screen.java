package com.learn.booking.bookingmanagementsystem.models;

import com.learn.booking.bookingmanagementsystem.enums.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Screen extends BaseModel {
    private String name;

    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();

    @OneToMany(mappedBy = "screen")
    private List<Seat> seat = new ArrayList<>();
}
