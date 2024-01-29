package com.example.expensemanagementsystem.command;

import com.example.expensemanagementsystem.controller.ExpenseController;
import com.example.expensemanagementsystem.dto.CreateUserExpenseRequest;
import com.example.expensemanagementsystem.models.ExpenseType;
import com.example.expensemanagementsystem.models.UserExpense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.expensemanagementsystem.command.Commands.ADD_USER_EXPENSE;

@Component
@AllArgsConstructor
public class AddUserExpenseCommand implements Command{
    private ExpenseController expenseController;

    @Override
    public boolean matches(String input) {
        if (getCommand(input).equals(ADD_USER_EXPENSE)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing create expense command");
        List<String> tokens = getTokens(input);
        CreateUserExpenseRequest request = CreateUserExpenseRequest.builder()
                .expenseId(Long.valueOf(tokens.get(1)))
                .userId(Long.valueOf(tokens.get(2)))
                .amount(Double.valueOf(tokens.get(3)))
                .type(ExpenseType.valueOf(tokens.get(4)))
                .build();
        UserExpense expense = expenseController.addUserExpense(request);
        System.out.println("Created expense with id: " + expense.getId());
    }
}
