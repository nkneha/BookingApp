package com.example.BookingApp.repository;

import com.example.BookingApp.model.SeatPricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISeatPricingRepo extends JpaRepository<SeatPricing,Long> {


    Optional<SeatPricing> findByClassType(String seatClass);
}
