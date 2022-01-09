package com.paypal.bfs.test.bookingservImpl.service;

import com.paypal.bfs.test.bookingservImpl.dao.BookingRepository;
import com.paypal.bfs.test.bookingservImpl.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public Optional<Booking> findById(String id) {

        Optional<Booking> bookingRecord = bookingRepository.findById(Integer.valueOf(id));
        if (bookingRecord.isPresent()) {
            if (Objects.nonNull(bookingRecord.get())) {
                return Optional.of(bookingRecord.get());
            }
        }
        return Optional.empty();
    }

    public boolean create(Booking booking) {
        try {
            if (Objects.nonNull(bookingRepository.save(booking))) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error in creating booking...");
        }
        return false;
    }


    public List<Booking> getAllRecords() {
        return bookingRepository.findAll();
    }
}
