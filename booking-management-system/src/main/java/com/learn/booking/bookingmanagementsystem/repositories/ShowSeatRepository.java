package com.learn.booking.bookingmanagementsystem.repositories;

import com.learn.booking.bookingmanagementsystem.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
}