package com.example.BookingApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String userPhone;
    private String userEmail;
    @OneToMany
    @JoinColumn(name = "booking_id")
    private List<Seat> seatIds;
    private double amount;




}
