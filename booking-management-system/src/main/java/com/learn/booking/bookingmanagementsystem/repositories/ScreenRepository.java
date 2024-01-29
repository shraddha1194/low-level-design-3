package com.learn.booking.bookingmanagementsystem.repositories;

import com.learn.booking.bookingmanagementsystem.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {
}
