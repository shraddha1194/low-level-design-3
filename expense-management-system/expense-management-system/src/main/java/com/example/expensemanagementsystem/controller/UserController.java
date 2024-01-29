package com.example.expensemanagementsystem.controller;

import com.example.expensemanagementsystem.dto.CreateUserDTO;
import com.example.expensemanagementsystem.models.User;
import com.example.expensemanagementsystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserController {

    private UserService userService;

    public User createUser(CreateUserDTO request) {
        return userService.createUser(request.toUser());
    }
}
