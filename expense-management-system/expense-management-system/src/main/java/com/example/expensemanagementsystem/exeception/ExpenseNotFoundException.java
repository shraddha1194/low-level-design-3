package com.example.expensemanagementsystem.exeception;

public class ExpenseNotFoundException extends RuntimeException{
    public ExpenseNotFoundException(Long expenseId) {
        super("Expense with id "+ expenseId + " not found" );
    }
}
