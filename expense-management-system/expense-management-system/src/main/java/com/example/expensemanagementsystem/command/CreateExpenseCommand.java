package com.example.expensemanagementsystem.command;

import com.example.expensemanagementsystem.controller.ExpenseController;
import com.example.expensemanagementsystem.dto.CreateExpenseRequest;
import com.example.expensemanagementsystem.models.Expense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static com.example.expensemanagementsystem.command.Commands.CREATE_EXPENSE_COMMAND;

@Component
@AllArgsConstructor
public class CreateExpenseCommand implements Command {

    private ExpenseController expenseController;
    @Override
    public boolean matches(String input) {
        if (getCommand(input).equals(CREATE_EXPENSE_COMMAND)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        System.out.println("Creating expense...");
        List<String> tokens = getTokens(input);
        List<Long> userIds = Arrays.stream(tokens.get(3).split(","))
                .map(Long::valueOf)
                .toList();
        CreateExpenseRequest request = CreateExpenseRequest.builder()
                .description(tokens.get(1))
                .amount(Double.valueOf(tokens.get(2)))
                .userIds(userIds)
                .build();
        Expense expense = expenseController.createExpense(request);
        System.out.println("Created expense with id: " + expense.getPaidBy());
    }
}
