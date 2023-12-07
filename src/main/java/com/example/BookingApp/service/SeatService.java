package com.example.BookingApp.service;

import com.example.BookingApp.model.Booking;
import com.example.BookingApp.model.Seat;
import com.example.BookingApp.model.SeatPricing;
import com.example.BookingApp.model.dto.BookingDetails;
import com.example.BookingApp.repository.IBookingRepo;
import com.example.BookingApp.repository.ISeatPricingRepo;
import com.example.BookingApp.repository.ISeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SeatService {
    @Autowired
    ISeatRepo seatRepo;

    @Autowired
    SeatPricingService seatPricingService;


    public boolean isSeatBooked(Long seatId) {
        Optional<Seat> seat = seatRepo.findById(seatId);
        return seat.map(Seat::isBooked).orElse(false);
    }
    public List<Seat> bookSeats(List<Long> seatIds) {
        List<Seat> bookedSeats = new ArrayList<>();

        for (Long seatId : seatIds) {
            Optional<Seat> seatOptional = seatRepo.findById(seatId);

            if (seatOptional.isPresent() && !seatOptional.get().isBooked()) {
                Seat seat = seatOptional.get();
                seat.setBooked(true);
                seatRepo.save(seat);
                bookedSeats.add(seat);
            }
        }

        return bookedSeats;
    }




    public List<Seat> getAllSeats() {
        return seatRepo.findAll();
    }



public ResponseEntity<BookingDetails> getSeatPricing(Long id) {

    Optional<Seat> seat = seatRepo.findById(id);
    BookingDetails seatDetails= new BookingDetails();

    if(seat.isPresent()){

        String seatClass = seat.get().getClassType();
        int totalSeatsInClass = getAllSeats().stream().filter(s -> s.getClassType().equals(seatClass)).toArray().length;
        int bookedSeats = (int) getAllSeats().stream().filter(Seat::isBooked).count();
        int percentageBooked = (bookedSeats * 100) / totalSeatsInClass;
        double amount = seatPricingService.calculateBookingAmount(seatClass, percentageBooked);

        seatDetails.setClassType(seat.get().getClassType());
        seatDetails.setId(seat.get().getId());
        seatDetails.setAmount(amount);
        seatDetails.setSeatsBooked(seat.get().isBooked());
        return new ResponseEntity<>(seatDetails, HttpStatus.OK);

    }
    return new ResponseEntity<>(seatDetails, HttpStatus.BAD_REQUEST);
}
}
