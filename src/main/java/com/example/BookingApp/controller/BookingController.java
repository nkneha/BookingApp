package com.example.BookingApp.controller;

import com.example.BookingApp.model.Booking;
import com.example.BookingApp.model.dto.BookingInput;
import com.example.BookingApp.service.BookingService;
import com.example.BookingApp.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    BookingService bookingService;
    @Autowired
    SeatService seatService;

    @PostMapping("/booking")
    public ResponseEntity<?> createBooking(@RequestBody BookingInput input) {
        List<Long> seatIds = input.getSeatIds();
        String userName = input.getUserName();
        String phoneNumber = input.getPhoneNumber();

        return bookingService.createBooking(seatIds, userName, phoneNumber);
    }

    @GetMapping("bookings")
    public ResponseEntity<?> getBookings(@RequestParam("userIdentifier") String userIdentifier) {
        List<Booking> bookings = bookingService.getBookingsByUserIdentifier(userIdentifier);
        return ResponseEntity.ok(bookings);
    }

}
