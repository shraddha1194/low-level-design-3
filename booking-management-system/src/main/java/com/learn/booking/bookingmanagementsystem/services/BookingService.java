package com.learn.booking.bookingmanagementsystem.services;

import com.learn.booking.bookingmanagementsystem.dtos.CreateBookingDTO;
import com.learn.booking.bookingmanagementsystem.enums.BookingStatus;
import com.learn.booking.bookingmanagementsystem.enums.SeatStatus;
import com.learn.booking.bookingmanagementsystem.exceptions.AlreadyBookedException;
import com.learn.booking.bookingmanagementsystem.models.Booking;
import com.learn.booking.bookingmanagementsystem.models.Customer;
import com.learn.booking.bookingmanagementsystem.models.Show;
import com.learn.booking.bookingmanagementsystem.models.ShowSeat;
import com.learn.booking.bookingmanagementsystem.repositories.BookingRepository;
import com.learn.booking.bookingmanagementsystem.strategies.pricing.PricingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingService {

    private BookingRepository bookingRepository;
    private CustomerService customerService;
    private ShowService showService;
    private ShowSeatService showSeatService;
    private PricingStrategy pricingStrategy;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(CreateBookingDTO request) {
        // Validate the customer
        Customer customer = customerService.getCustomerInternal(request.getCustomerId());
        if (Objects.isNull(customer)) {
            throw new NoSuchElementException("Customer does not exist: " + request.getCustomerId());
        }
        // Validate the show
        Show show = showService.getShow(request.getShowId());
        if (Objects.isNull(show)) {
            throw new NoSuchElementException("Show does not exist: " + request.getShowId());
        }
        // validate the showSeats
        List<ShowSeat> showSeats = showSeatService.getShowSeat(request.getShowSeatsIds());
        // check if showSeats are available
        boolean areAllSeatsAvailable = showSeats.stream().allMatch(seat -> SeatStatus.AVAILABLE.equals(seat.getStatus()));
        if (!areAllSeatsAvailable) {
            throw new AlreadyBookedException(request.getShowSeatsIds());
        }
        // If available, lock the seats
        List<ShowSeat> lockedSeats = showSeats.stream().map(seat -> seat.toBuilder().status(SeatStatus.LOCKED).build()).collect(Collectors.toList());
        // Save the locked seats
        showSeatService.saveAll(lockedSeats);
        // save the booking
        Booking booking = Booking.builder()
                .customer(customer)
                .seats(lockedSeats)
                .bookedAt(new Date())
                .status(BookingStatus.PENDING)
                .build();
        Double amount = pricingStrategy.calculatePrice(booking);
        booking.toBuilder().amount(amount).build();
        return bookingRepository.save(booking);
    }
}
