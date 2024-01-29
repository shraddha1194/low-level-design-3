package com.example.expensemanagementsystem.service;

import com.example.expensemanagementsystem.dto.CreateExpenseRequest;
import com.example.expensemanagementsystem.dto.CreateUserExpenseRequest;
import com.example.expensemanagementsystem.exeception.ExpenseNotFoundException;
import com.example.expensemanagementsystem.models.Expense;
import com.example.expensemanagementsystem.models.UserExpense;
import com.example.expensemanagementsystem.repository.ExpenseRepository;
import com.example.expensemanagementsystem.models.ExpenseStatus;
import com.example.expensemanagementsystem.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseService {
    private UserService userService;
    private ExpenseRepository expenseRepository;
    private UserExpenseService userExpenseService;

    public Expense createExpense(CreateExpenseRequest request) {
        List<User> users = userService.getUsers(request.getUserIds());
        Expense expense = Expense.builder()
                .description(request.getDescription())
                .amount(request.getAmount())
                .users(users)
                .status(ExpenseStatus.PENDING)
                .build();
        return expenseRepository.save(expense);
    }


    public UserExpense addUserExpense(CreateUserExpenseRequest request) {
        Expense expense = expenseRepository.
                findById(request.getExpenseId())
                .orElseThrow(() -> new ExpenseNotFoundException(request.getExpenseId()));
        User user = userService.getUser(request.getUserId());
        UserExpense userExpense = UserExpense.builder()
                .expense(expense)
                .user(user)
                .amount(request.getAmount())
                .type(request.getType())
                .build();
        return userExpenseService.createUserExpense(userExpense);
    }
}
