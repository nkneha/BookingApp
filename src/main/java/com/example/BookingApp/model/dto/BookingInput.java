package com.example.BookingApp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingInput {
    private List<Long> seatIds;
    private String userName;
    private String phoneNumber;
}
