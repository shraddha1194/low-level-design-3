package com.example.expensemanagementsystem.command;

import com.example.expensemanagementsystem.controller.UserController;
import com.example.expensemanagementsystem.dto.CreateUserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static com.example.expensemanagementsystem.command.Commands.REGISTER_USER_COMMAND;

@Component
@AllArgsConstructor
public class CreateUserCommand implements Command {

    private UserController userController;
    @Override
    public boolean matches(String input) {
        if (getCommand(input).equals(REGISTER_USER_COMMAND)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        List<String> tokens = getTokens(input);
        CreateUserDTO createUserDTO = CreateUserDTO.builder()
                .name(tokens.get(1))
                .email(tokens.get(2))
                .password(tokens.get(3))
                .phoneNumber(tokens.get(4))
                        .build();
        // UserController to be invoked
        userController.createUser(createUserDTO);
    }
}
