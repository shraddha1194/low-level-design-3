package com.example.expensemanagementsystem.models;

import jakarta.persistence.*;


@Entity
public class GroupExpense extends BaseModel {

    @ManyToOne
    private Group group;

    @OneToOne
    private Expense expense;
}
