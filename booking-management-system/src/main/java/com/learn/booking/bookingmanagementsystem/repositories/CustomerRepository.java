package com.learn.booking.bookingmanagementsystem.repositories;

import com.learn.booking.bookingmanagementsystem.models.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Function;

//Specify the entity and type of primary key to create our repository

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomersByEmail(String email);
}
