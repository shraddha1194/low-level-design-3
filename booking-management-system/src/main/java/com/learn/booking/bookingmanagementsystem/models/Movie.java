package com.learn.booking.bookingmanagementsystem.models;

import com.learn.booking.bookingmanagementsystem.enums.Language;
import com.learn.booking.bookingmanagementsystem.enums.MovieFeature;
import com.learn.booking.bookingmanagementsystem.enums.Genre;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie extends BaseModel {
    private String name;
    private Double rating;

    @ElementCollection // Used when we have a collection that is not an entity
    @Enumerated
    private List<Language> language = new ArrayList<>();

    @ElementCollection
    @Enumerated
    private List<Genre> genre = new ArrayList<>();

    @ElementCollection
    @Enumerated
    private List<MovieFeature> movieFeature = new ArrayList<>();

    // All the annotations by default are uni-directional
    // for bidirectional relations we need to use mappedBy
    // we have 1 to many relation here so Show is parent entity, movie is the child entity which have incorrect reference or it should not have reference
    // mapped by uses the field name from the parent entity
    // Add @JoinColumn tells hibernate what is the foreign key
    @OneToMany(mappedBy = "movie")
    private List<Show> show = new ArrayList<>();
}
