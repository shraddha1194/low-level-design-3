package com.learn.booking.bookingmanagementsystem.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity // will map to city table in db
public class City extends BaseModel {

    private String name;

    @OneToMany // cardinality - establish relation between city and theater
    private List<Theater> theater = new ArrayList<>();
}
