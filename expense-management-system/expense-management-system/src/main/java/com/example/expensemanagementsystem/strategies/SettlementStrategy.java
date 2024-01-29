package com.example.expensemanagementsystem.strategies;

import com.example.expensemanagementsystem.dto.SettleUpTransaction;
import com.example.expensemanagementsystem.models.Expense;

import java.util.List;

public interface SettlementStrategy {

    List<SettleUpTransaction> settleUp(List<Expense> expense);
}
