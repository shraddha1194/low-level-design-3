package com.example.expensemanagementsystem.service;


import com.example.expensemanagementsystem.dto.CreateGroupRequest;
import com.example.expensemanagementsystem.models.Group;
import com.example.expensemanagementsystem.models.User;
import com.example.expensemanagementsystem.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupService {

    private GroupRepository groupRepository;
    private UserService userService;

    public Group createGroup(CreateGroupRequest request) {
        User createdBy = userService.getUser(request.getCreatedBy());
        List<User> members = userService.getUsers(request.getMemberIds());
        Group group = Group.builder()
                .name(request.getName())
                .createdBy(createdBy)
                .members(members)
                .admin(List.of(createdBy))
                .build();
        return groupRepository.save(group);
    }

    public Group getGroup(Long groupId) {
        return groupRepository.findById(groupId).orElse(null);
    }
}
