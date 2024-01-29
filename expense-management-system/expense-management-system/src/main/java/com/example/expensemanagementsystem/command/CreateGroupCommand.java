package com.example.expensemanagementsystem.command;

import com.example.expensemanagementsystem.controller.GroupController;
import com.example.expensemanagementsystem.dto.CreateGroupRequest;
import com.example.expensemanagementsystem.models.Group;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.expensemanagementsystem.command.Commands.CREATE_GROUP_COMMAND;

@Component
public class CreateGroupCommand implements Command {

    private GroupController groupController;
    @Override
    public boolean matches(String input) {
        String command = getCommand(input);
        if (command.equals(CREATE_GROUP_COMMAND)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        System.out.println("Creating group...");
        List<String> tokens = getTokens(input);
        List<Long> memberIds = Arrays.stream(tokens.get(3).split(","))
                .map(Long::valueOf)
                .toList();
        CreateGroupRequest request = CreateGroupRequest.builder()
                .name(tokens.get(1))
                .createdBy(Long.valueOf(tokens.get(2)))
                .memberIds(memberIds)
                .build();

        Group group = groupController.createGroup(request);
        System.out.println("Created group with id: " + group.getId());
    }
}
