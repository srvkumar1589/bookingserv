package com.paypal.bfs.test.bookingservImpl.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingservImpl.errorModel.BookingSytemException;
import com.paypal.bfs.test.bookingservImpl.inputvalidator.BookingInputValidator;
import com.paypal.bfs.test.bookingservImpl.model.Booking;
import com.paypal.bfs.test.bookingservImpl.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BookingResourceImpl implements BookingResource {

    @Autowired
    BookingInputValidator bookingInputValidator;

    @Autowired
    BookingService bookingService;

    @Override
    public ResponseEntity create(Map<String, Object> bookingBody) {
        try {
            Booking bookinRequestBody = bookingInputValidator.validateBookingFields(bookingBody);

            if (null != bookinRequestBody.getId()) {
                Optional<Booking> booking = bookingService.findById(bookinRequestBody.getId() + "");
                if (booking.isPresent()) {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Booking record Exists!");
                }
            }

            Boolean isCreated = bookingService.create(bookinRequestBody);
            if (isCreated)
                return ResponseEntity.status(HttpStatus.CREATED).body(bookinRequestBody);
            else
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        } catch (BookingSytemException bk) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bk.getErrors());
        }
    }

    @Override
    public ResponseEntity<List<Booking>> bookingGetAllRecords() {
        return ResponseEntity.status(HttpStatus.OK).body(bookingService.getAllRecords());
    }
}
