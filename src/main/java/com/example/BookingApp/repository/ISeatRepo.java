package com.example.BookingApp.repository;

import com.example.BookingApp.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeatRepo extends JpaRepository<Seat,Long> {

}
