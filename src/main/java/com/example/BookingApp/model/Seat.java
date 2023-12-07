package com.example.BookingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

@NoArgsConstructor

@Entity
public class Seat {
    @Id
    private Long id;
    private String classType;
    private String seat_identifiers;
    private boolean isBooked=false;
}
