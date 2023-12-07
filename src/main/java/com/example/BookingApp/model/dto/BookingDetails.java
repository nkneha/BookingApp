package com.example.BookingApp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookingDetails {
    private Long id;
    private String classType;
    private double amount;
    private boolean seatsBooked;

}
