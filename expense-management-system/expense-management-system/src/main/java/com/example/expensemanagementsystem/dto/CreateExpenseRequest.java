package com.example.expensemanagementsystem.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CreateExpenseRequest {
    private String description;
    private Double amount;
    private List<Long> userIds = new ArrayList<>();
}
