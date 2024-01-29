package com.example.expensemanagementsystem.service;

import com.example.expensemanagementsystem.models.User;
import com.example.expensemanagementsystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public User createUser(User request) {
        // Hash the password
        // create a new user
        String password = passwordEncoder.encode(request.getPassword());
        User user = request.toBuilder().password(password).build();
        return userRepository.save(user);
    }

    public User getUser(Long createdBy) {
       return userRepository.findById(createdBy).orElse(null);
    }

    public List<User> getUsers(List<Long> memberIds) {
        return userRepository.findAllById(memberIds);
    }
}
