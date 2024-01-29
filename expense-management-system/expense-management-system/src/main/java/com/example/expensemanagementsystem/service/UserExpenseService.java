package com.example.expensemanagementsystem.service;

import com.example.expensemanagementsystem.models.UserExpense;
import com.example.expensemanagementsystem.repository.UserExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserExpenseService {
    private UserExpenseRepository userExpenseRepository;

    public UserExpense createUserExpense(UserExpense userExpense) {
        return userExpenseRepository.save(userExpense);
    }
}
