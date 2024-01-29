package com.learn.booking.bookingmanagementsystem.repositories;

import com.learn.booking.bookingmanagementsystem.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findMovieByName(String movieName);
}