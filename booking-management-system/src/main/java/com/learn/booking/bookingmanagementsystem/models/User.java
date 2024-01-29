package com.learn.booking.bookingmanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity // tells JPA we need to map this call to table in db
@Table(name = "users") // allows us to add/modify the metadata of the table ex. name, schema, add indexes
public class User extends BaseModel {
    private String username;
    private String password;
}
