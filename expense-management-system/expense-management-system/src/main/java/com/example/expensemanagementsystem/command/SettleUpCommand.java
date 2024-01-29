package com.example.expensemanagementsystem.command;

import java.util.Arrays;
import java.util.List;

import static com.example.expensemanagementsystem.command.Commands.SETTLE_EXPENSE_COMMAND;

public class SettleUpCommand implements Command{
    @Override
    public boolean matches(String input) {

        if (getCommand(input).equals(SETTLE_EXPENSE_COMMAND)) {
            return true;
        }

        return false;
    }

    @Override
    public void execute(String input) {

    }
}
