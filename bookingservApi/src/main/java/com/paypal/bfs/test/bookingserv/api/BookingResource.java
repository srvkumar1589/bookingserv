package com.paypal.bfs.test.bookingserv.api;

import com.paypal.bfs.test.bookingservImpl.model.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

public interface BookingResource {
    /**
     * Create {@link Booking} resource
     *
     * @param booking the booking object
     * @return the created booking
     */
    @RequestMapping(value = "/v1/bfs/booking", method = RequestMethod.POST)
    ResponseEntity<Booking> create(@RequestBody Map<String, Object> booking);

    // ----------------------------------------------------------
    // TODO - add a new operation for Get All the bookings resource.
    // ----------------------------------------------------------
    @RequestMapping(value = "/v1/bfs/booking", method = RequestMethod.GET)
    ResponseEntity<List<Booking>> bookingGetAllRecords();
}
