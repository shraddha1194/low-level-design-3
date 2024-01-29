package com.example.expensemanagementsystem.command;

import java.util.Arrays;
import java.util.List;

public interface Command {

    boolean matches(String input);

    void execute(String input);

    default String getCommand(String input) {
        return getTokens(input).get(0);
    }

    default List<String> getTokens(String input) {
        return Arrays.stream(input.split(" ")).toList();
    }
}
