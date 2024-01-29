package com.learn.booking.bookingmanagementsystem.dtos;

import com.learn.booking.bookingmanagementsystem.enums.Genre;
import com.learn.booking.bookingmanagementsystem.enums.Language;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MovieRequestDTO {
    private String name;
    private Double rating;
    private List<Language> language = new ArrayList<>();
    private List<Genre> genre = new ArrayList<>();
}
