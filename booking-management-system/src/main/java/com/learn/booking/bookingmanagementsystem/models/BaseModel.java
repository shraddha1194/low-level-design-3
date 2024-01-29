package com.learn.booking.bookingmanagementsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@MappedSuperclass // This is not a JPA entity but just a super class/parent of all the entities
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel {
    @Id // tells JPA this is the primary key in our db
    @GeneratedValue(strategy = GenerationType.IDENTITY) // created auto generated id for us - identity generates 1, 2, 3... such type of ids for us
    private Long id;

    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedAt;

}
