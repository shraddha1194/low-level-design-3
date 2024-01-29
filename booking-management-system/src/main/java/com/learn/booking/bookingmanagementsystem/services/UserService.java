package com.learn.booking.bookingmanagementsystem.services;

import com.learn.booking.bookingmanagementsystem.models.User;
import com.learn.booking.bookingmanagementsystem.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User createUser(String username, String password) {
        User user = new User(username, password);
        return userRepository.save(user);
    }

}
