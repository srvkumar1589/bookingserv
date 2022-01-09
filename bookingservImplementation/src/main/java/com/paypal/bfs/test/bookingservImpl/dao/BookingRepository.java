package com.paypal.bfs.test.bookingservImpl.dao;

import com.paypal.bfs.test.bookingservImpl.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
