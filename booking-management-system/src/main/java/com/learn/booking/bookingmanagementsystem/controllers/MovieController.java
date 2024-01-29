package com.learn.booking.bookingmanagementsystem.controllers;

import com.learn.booking.bookingmanagementsystem.dtos.MovieRequestDTO;
import com.learn.booking.bookingmanagementsystem.exceptions.movies.InvalidMovieException;
import com.learn.booking.bookingmanagementsystem.models.Movie;
import com.learn.booking.bookingmanagementsystem.services.MovieService;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{movieName}")
    public Movie getMovie(@PathVariable String movieName) {
        return movieService.getMovie(movieName);
    }

    @PostMapping
    public Movie createMovie(@RequestBody MovieRequestDTO request) {
        validate(request);
        return movieService.createMovie(request);
    }

    private void validate(MovieRequestDTO request) {
        if (StringUtils.isEmpty(request.getName())) {
            throw new InvalidMovieException();
        }
    }
}
