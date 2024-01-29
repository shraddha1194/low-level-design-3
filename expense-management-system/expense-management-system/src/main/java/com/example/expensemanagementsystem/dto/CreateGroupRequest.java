package com.example.expensemanagementsystem.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class  CreateGroupRequest {
    private String name;
    private Long createdBy;
    private List<Long> memberIds = new ArrayList<>();
}
