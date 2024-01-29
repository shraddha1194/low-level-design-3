package com.example.expensemanagementsystem.dto;

import com.example.expensemanagementsystem.models.ExpenseType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserExpenseRequest {
    private Long expenseId;
    private Long userId;
    private Double amount;
    private ExpenseType type;
}
