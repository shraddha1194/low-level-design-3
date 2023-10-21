package com.learn.parkinglot.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Getter
@Setter
public abstract class BaseModel {
    private Long id;
    @Builder.Default
    private Date createdAt = new Date();
    private Date updatedAt;
}
