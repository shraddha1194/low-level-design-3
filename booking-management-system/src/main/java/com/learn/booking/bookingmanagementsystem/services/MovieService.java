package com.learn.booking.bookingmanagementsystem.services;

import com.learn.booking.bookingmanagementsystem.dtos.MovieRequestDTO;
import com.learn.booking.bookingmanagementsystem.exceptions.movies.MovieAlreadyExistsException;
import com.learn.booking.bookingmanagementsystem.exceptions.movies.MovieNotFoundException;
import com.learn.booking.bookingmanagementsystem.models.Movie;
import com.learn.booking.bookingmanagementsystem.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {

    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovie(String name) {
        return movieRepository.findMovieByName(name)
                .orElseThrow(() ->  new MovieNotFoundException(name));
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElse(null);
    }

    public Movie createMovie(MovieRequestDTO request) {
        Optional<Movie> existingMovie = movieRepository.findMovieByName(request.getName());

        if (existingMovie.isPresent()) {
            throw new MovieAlreadyExistsException(request.getName());
        }

        Movie movie = Movie.builder()
                    .name(request.getName())
                    .rating(request.getRating())
                    .language(request.getLanguage())
                    .genre(request.getGenre())
                    .build();

        return movieRepository.save(movie);
    }

}
