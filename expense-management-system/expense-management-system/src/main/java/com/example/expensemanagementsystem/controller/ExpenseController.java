package com.example.expensemanagementsystem.controller;

import com.example.expensemanagementsystem.dto.CreateExpenseRequest;
import com.example.expensemanagementsystem.dto.CreateUserExpenseRequest;
import com.example.expensemanagementsystem.models.Expense;
import com.example.expensemanagementsystem.models.User;
import com.example.expensemanagementsystem.models.UserExpense;
import com.example.expensemanagementsystem.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExpenseController {

    private ExpenseService expenseService;
    public Expense createExpense(CreateExpenseRequest request) {
        return expenseService.createExpense(request);
    }

    public UserExpense addUserExpense(CreateUserExpenseRequest request) {
        return expenseService.addUserExpense(request);
    }
}
