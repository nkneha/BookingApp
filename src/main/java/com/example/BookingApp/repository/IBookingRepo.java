package com.example.BookingApp.repository;

import com.example.BookingApp.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookingRepo extends JpaRepository<Booking,Integer> {
    List<Booking> findByUserNameOrUserPhone(String userIdentifier, String userIdentifier1);
}
