package com.example.BookingApp.controller;

import com.example.BookingApp.model.Seat;
import com.example.BookingApp.model.SeatPricing;
import com.example.BookingApp.model.dto.BookingDetails;
import com.example.BookingApp.repository.ISeatPricingRepo;
import com.example.BookingApp.repository.ISeatRepo;
import com.example.BookingApp.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SeatController {
    @Autowired
    SeatService seatService;
    @Autowired
    ISeatPricingRepo seatPricingRepo;
    @Autowired
    ISeatRepo seatRepo;
    @GetMapping("seats")
    public List<Seat> getAllSeats(){
        return seatService.getAllSeats();
    }
    @GetMapping("seats/{id}")
    public ResponseEntity<BookingDetails> getSeatPricing(@PathVariable Long id) {
        return seatService.getSeatPricing(id);
    }




}
