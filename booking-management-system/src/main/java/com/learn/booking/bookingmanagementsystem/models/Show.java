package com.learn.booking.bookingmanagementsystem.models;


import com.learn.booking.bookingmanagementsystem.enums.Language;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shows")
public class Show extends BaseModel {
    private Date startTime;
    private Integer duration;

    // Show will have a foreign key movie_id which it will use to fetch the movie entity
    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;

    @Enumerated
    private Language language;

    @OneToMany(mappedBy = "show")
    private  List<ShowSeat> showSeats = new ArrayList<>();

    @ManyToOne
    private Screen screen;
}
