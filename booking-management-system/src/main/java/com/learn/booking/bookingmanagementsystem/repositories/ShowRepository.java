package com.learn.booking.bookingmanagementsystem.repositories;

import com.learn.booking.bookingmanagementsystem.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
}