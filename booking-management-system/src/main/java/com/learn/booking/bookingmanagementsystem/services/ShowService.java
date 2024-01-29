package com.learn.booking.bookingmanagementsystem.services;

import com.learn.booking.bookingmanagementsystem.dtos.CreateShowRequestDTO;
import com.learn.booking.bookingmanagementsystem.enums.SeatStatus;
import com.learn.booking.bookingmanagementsystem.models.*;
import com.learn.booking.bookingmanagementsystem.repositories.ShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShowService {

    private ScreenService screenService;
    private MovieService movieService;
    private ShowRepository showRepository;
    private SeatService seatService;
    private ShowSeatService showSeatService;

    public Show createShow(CreateShowRequestDTO request) {
        // validate the screen
        Screen screen = screenService.getScreen(request.getScreenId());
        if (Objects.isNull(screen)) {
            throw new NoSuchElementException("Screen does not exist: " + request.getScreenId());
        }
        // validate movie
        Movie movie = movieService.getMovieById(request.getMovieId());
        if (Objects.isNull(movie)) {
            throw new NoSuchElementException("Movie does not exist: " + request.getMovieId());
        }
        // persist the show
        Show show = Show.builder()
                .startTime(request.getStartTime())
                .screen(screen)
                .movie(movie)
                .language(request.getLanguage())
                .build();
        showRepository.save(show);
        // persist the show seats
        List<Seat> seats = seatService.getAll(screen.getId());
        List<ShowSeat> showSeats = seats.stream()
                .map(seat -> ShowSeat.builder()
                        .seat(seat)
                        .show(show)
                        .status(SeatStatus.AVAILABLE)
                        .build()).collect(Collectors.toList());
        showSeatService.create(showSeats);

        return show;
    }

    public Show getShow(Long id) {
        return showRepository.findById(id).orElse(null);
    }
}
