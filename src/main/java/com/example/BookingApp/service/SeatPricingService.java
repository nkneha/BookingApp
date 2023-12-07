package com.example.BookingApp.service;

import com.example.BookingApp.model.SeatPricing;
import com.example.BookingApp.repository.ISeatPricingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeatPricingService {
    @Autowired
    ISeatPricingRepo seatPricingRepo;
    public Optional<SeatPricing> getPricingBySeatClass(String seatClass) {
        return seatPricingRepo.findByClassType(seatClass);
    }
    public double calculateBookingAmount(String seatClass, int percentageBooked) {
        Optional<SeatPricing> pricingOptional = getPricingBySeatClass(seatClass);
        double price = 0;

        if (pricingOptional.isPresent()) {
            SeatPricing pricing = pricingOptional.get();


            if (percentageBooked < 40) {
                price= pricing.getMinPrice();
            } else if (percentageBooked <= 60) {
                price= pricing.getNormalPrice();
            } else {
                price =pricing.getMaxPrice();
            }
        }
        if(price ==0){
            return pricingOptional.get().getNormalPrice();
        }
        return price;
    }
}
