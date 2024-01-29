package com.example.expensemanagementsystem.controller;

import com.example.expensemanagementsystem.dto.CreateGroupRequest;
import com.example.expensemanagementsystem.models.Group;
import com.example.expensemanagementsystem.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class GroupController {

    private GroupService groupService;
    public Group createGroup(CreateGroupRequest request) {
        return groupService.createGroup(request);
    }
}
