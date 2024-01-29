package com.learn.booking.bookingmanagementsystem.dtos;

import com.learn.booking.bookingmanagementsystem.enums.Language;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class CreateShowRequestDTO {
    private Date startTime;
    private Long movieId;
    private Long screenId;
    private Language language;
}
