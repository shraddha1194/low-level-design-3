package com.example.expensemanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserExpense extends BaseModel {

    @ManyToOne
    private User user;

    @ManyToOne //Parent entity
    @JoinColumn(name="expense_id")
    private Expense expense;

    private Double amount;
    private ExpenseType type;
}
