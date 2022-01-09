package com.paypal.bfs.test.bookingservImpl.inputvalidator;


import com.paypal.bfs.test.bookingservImpl.errorModel.BookingSytemException;
import com.paypal.bfs.test.bookingservImpl.errorModel.Errors;
import com.paypal.bfs.test.bookingservImpl.model.Booking;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

@Component
public class BookingInputValidator {
    private static final String ID = "id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String DATE_OF_BIRTH = "date_of_birth";
    private static final String CHECKIN_DATE_TIME = "checkin_datetime";
    private static final String CHECKOUT_DATE_TIME = "checkout_datetime";
    private static final String TOTAL_PRICE = "total_price";
    private static final String DEPOSIT = "deposit";
    private static final String ADDRESS_LINE_1 = "address_line1";
    private static final String ADDRESS_LINE_2 = "address_line2";
    private static final String CITY = "city";
    private static final String STATE = "state";
    private static final String ZIP_CODE = "zip_code";
    private static final String COUNTRY = "country";
    private static final String REQUIRED = " is required";


    public Booking validateBookingFields(Map<String, Object> bookingBody) throws BookingSytemException {
        Booking booking = new Booking();

        validateId(bookingBody, booking);
        validateFirstName(bookingBody, booking);
        validateLastName(bookingBody, booking);
        validateDateOfBirth(bookingBody, booking);
        validateCheckinDateTime(bookingBody, booking);
        validateCheckoutDateTime(bookingBody, booking);
        validateTotalPrice(bookingBody, booking);
        validateDeposit(bookingBody, booking);
        validateAddressLine1(bookingBody, booking);
        validateAddressLine2(bookingBody, booking);
        validateCity(bookingBody, booking);
        validateCountry(bookingBody, booking);
        validateState(bookingBody, booking);
        validateZipCode(bookingBody, booking);

//        return errorsList.size() > 0 ? Optional.of(errorsList) : Optional.empty();
        return booking;
    }


    private void validateId(Map<String, Object> bookingBody, Booking booking) throws BookingSytemException {
        Integer id = null;
        try {
            if (!StringUtils.isEmpty((String) bookingBody.get(ID)))
                id = Integer.parseInt(((String) bookingBody.get(ID)));
        } catch (ClassCastException e) {
            id = (Integer) bookingBody.get(ID);
        } catch (Exception e) {
            System.out.println("Bad_request.BOOKING_ID_INVALID_VALUE");
            Errors errors = new Errors("E-0-0", "ID INVALID VALUE");
            throw new BookingSytemException(e.getMessage(), errors);
        }
        if (null != id)
            booking.setId(id);
    }

    private void validateFirstName(Map<String, Object> bookingBody, Booking booking) throws BookingSytemException {
        String firstName = null;
        try {
            if (!StringUtils.isEmpty((String) bookingBody.get(FIRST_NAME)) && ((String) bookingBody.get(FIRST_NAME)).length() > 255)
                throw new IllegalStateException("Exceeds MAX LENGTH");
            else if (!StringUtils.isEmpty((String) bookingBody.get(FIRST_NAME)))
                firstName = (String) bookingBody.get(FIRST_NAME);
        } catch (Exception e) {
            System.out.println("Bad_request.BOOKING_FIRSTNAME_INVALID_VALUE");
            Errors errors = new Errors("E-0-0", e.getMessage());
            throw new BookingSytemException(e.getMessage(), errors);
        }
        if (null == firstName) {
            System.out.println("Bad_request.BOOKING_FIRSTNAME_REQUIRED_VALUE");
            Errors errors = new Errors("E-0-1", FIRST_NAME + REQUIRED);
            throw new BookingSytemException(REQUIRED, errors);
        } else
            booking.setFirstName(firstName);
    }

    private void validateLastName(Map<String, Object> bookingBody, Booking booking) throws BookingSytemException {
        String lastName = null;
        try {
            if (!StringUtils.isEmpty((String) bookingBody.get(LAST_NAME)) && ((String) bookingBody.get(LAST_NAME)).length() > 255)
                throw new IllegalStateException("Exceeds MAX LENGTH");
            else if (!StringUtils.isEmpty((String) bookingBody.get(LAST_NAME)))
                lastName = (String) bookingBody.get(LAST_NAME);
        } catch (Exception e) {
            System.out.println("Bad_request.BOOKING_LASTNAME_INVALID_VALUE");
            Errors errors = new Errors("E-0-0", e.getMessage());
            throw new BookingSytemException(e.getMessage(), errors);
        }
        if (null == lastName) {
            System.out.println("Bad_request.BOOKING_LASTNAME_REQUIRED_VALUE");
            Errors errors = new Errors("E-0-1", LAST_NAME + REQUIRED);
            throw new BookingSytemException(REQUIRED, errors);
        } else
            booking.setLastName(lastName);
    }

    private void validateDateOfBirth(Map<String, Object> bookingBody, Booking booking) throws BookingSytemException {
        String dateOfBirth = null;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            if (!StringUtils.isEmpty((String) bookingBody.get(DATE_OF_BIRTH)) && ((String) bookingBody.get(DATE_OF_BIRTH)).length() > 10)
                throw new IllegalStateException("Exceeds MAX LENGTH");
            else if (!StringUtils.isEmpty((String) bookingBody.get(DATE_OF_BIRTH))) {
                dateFormatter.parse((String) bookingBody.get(DATE_OF_BIRTH));
                dateOfBirth = (String) bookingBody.get(DATE_OF_BIRTH);
            }
        } catch (Exception e) {
            System.out.println("Bad_request.BOOKING_DATEOFBIRTH_INVALID_VALUE");
            Errors errors = new Errors("E-0-0", e.getMessage());
            throw new BookingSytemException(e.getMessage(), errors);
        }
        if (null == dateOfBirth) {
            System.out.println("Bad_request.BOOKING_DATEOFBIRTH_REQUIRED_VALUE");
            Errors errors = new Errors("E-0-1", DATE_OF_BIRTH + REQUIRED);
            throw new BookingSytemException(REQUIRED, errors);
        } else
            booking.setDateOfBirth(dateOfBirth);
    }

    private void validateCheckinDateTime(Map<String, Object> bookingBody, Booking booking) throws BookingSytemException {
        Date checkinDateTime = null;
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if (!StringUtils.isEmpty((String) bookingBody.get(CHECKIN_DATE_TIME))) {
                checkinDateTime = formatter.parse((String) bookingBody.get(CHECKIN_DATE_TIME));
            }
        } catch (Exception e) {
            System.out.println("Bad_request.BOOKING_CHECKIN_DATE_TIME_INVALID_VALUE");
            Errors errors = new Errors("E-0-0", CHECKIN_DATE_TIME+" : "+e.getMessage());
            throw new BookingSytemException(e.getMessage(), errors);
        }
        if (null == checkinDateTime) {
            System.out.println("Bad_request.BOOKING_CHECKIN_DATE_TIME_REQUIRED_VALUE");
            Errors errors = new Errors("E-0-1", CHECKIN_DATE_TIME + REQUIRED);
            throw new BookingSytemException(REQUIRED, errors);
        } else
            booking.setCheckinDatetime(checkinDateTime);
    }

    private void validateCheckoutDateTime(Map<String, Object> bookingBody, Booking booking) throws BookingSytemException {
        Date checkoutDateTime = null;
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if (!StringUtils.isEmpty((String) bookingBody.get(CHECKOUT_DATE_TIME))) {
                checkoutDateTime = formatter.parse((String) bookingBody.get(CHECKOUT_DATE_TIME));
            }
        } catch (Exception e) {
            System.out.println("Bad_request.BOOKING_CHECKOUT_DATE_TIME_INVALID_VALUE");
            Errors errors = new Errors("E-0-0", CHECKOUT_DATE_TIME+" : "+e.getMessage());
            throw new BookingSytemException(e.getMessage(), errors);
        }
        if (null == checkoutDateTime) {
            System.out.println("Bad_request.BOOKING_CHECKOUT_DATE_TIME_REQUIRED_VALUE");
            Errors errors = new Errors("E-0-1", CHECKOUT_DATE_TIME + REQUIRED);
            throw new BookingSytemException(REQUIRED, errors);
        } else
            booking.setCheckoutDatetime(checkoutDateTime);
    }

    private void validateTotalPrice(Map<String, Object> bookingBody, Booking booking) throws BookingSytemException {
        Double totalPrice = null;
        try {
            if (!StringUtils.isEmpty((String) bookingBody.get(TOTAL_PRICE)))
                totalPrice = Double.parseDouble(((String) bookingBody.get(TOTAL_PRICE)));
        } catch (ClassCastException e) {
            totalPrice = (Double) bookingBody.get(TOTAL_PRICE);
        } catch (Exception e) {
            System.out.println("Bad_request.BOOKING_TOTAL_PRICE_INVALID_VALUE");
            Errors errors = new Errors("E-0-0", e.getMessage());
            throw new BookingSytemException(e.getMessage(), errors);
        }
        if (null == totalPrice) {
            System.out.println("Bad_request.BOOKING_TOTAL_PRICE_REQUIRED_VALUE");
            Errors errors = new Errors("E-0-1", TOTAL_PRICE + REQUIRED);
            throw new BookingSytemException(REQUIRED, errors);
        } else
            booking.setTotalPrice(totalPrice);
    }

    private void validateDeposit(Map<String, Object> bookingBody, Booking booking) throws BookingSytemException {
        Double deposit = null;
        try {
            if (!StringUtils.isEmpty((String) bookingBody.get(DEPOSIT)))
                deposit = Double.parseDouble(((String) bookingBody.get(DEPOSIT)));
        } catch (ClassCastException e) {
            deposit = (Double) bookingBody.get(DEPOSIT);
        } catch (Exception e) {
            System.out.println("Bad_request.BOOKING_DEPOSIT_INVALID_VALUE");
            Errors errors = new Errors("E-0-0", e.getMessage());
            throw new BookingSytemException(e.getMessage(), errors);
        }
        if (null == deposit) {
            System.out.println("Bad_request.BOOKING_DEPOSIT_REQUIRED_VALUE");
            Errors errors = new Errors("E-0-1", DEPOSIT + REQUIRED);
            throw new BookingSytemException(REQUIRED, errors);
        } else
            booking.setDeposit(deposit);
    }

    private void validateAddressLine1(Map<String, Object> bookingBody, Booking booking) throws BookingSytemException {
        String addressLine1 = null;
        try {
            if (!StringUtils.isEmpty((String) bookingBody.get(ADDRESS_LINE_1)) && ((String) bookingBody.get(ADDRESS_LINE_1)).length() > 255)
                throw new IllegalStateException("Exceeds MAX LENGTH");
            else if (!StringUtils.isEmpty((String) bookingBody.get(ADDRESS_LINE_1)))
                addressLine1 = (String) bookingBody.get(ADDRESS_LINE_1);
        } catch (Exception e) {
            System.out.println("Bad_request.BOOKING_ADDRESS_LINE_1_INVALID_VALUE");
            Errors errors = new Errors("E-0-0", e.getMessage());
            throw new BookingSytemException(e.getMessage(), errors);
        }
        if (null == addressLine1) {
            System.out.println("Bad_request.BOOKING_ADDRESS_LINE_1_REQUIRED_VALUE");
            Errors errors = new Errors("E-0-1", ADDRESS_LINE_1 + REQUIRED);
            throw new BookingSytemException(REQUIRED, errors);
        } else
            booking.setAddressLine1(addressLine1);
    }

    private void validateAddressLine2(Map<String, Object> bookingBody, Booking booking) throws BookingSytemException {
        String addressLine2 = null;
        try {
            if (!StringUtils.isEmpty((String) bookingBody.get(ADDRESS_LINE_2)) && ((String) bookingBody.get(ADDRESS_LINE_2)).length() > 255)
                throw new IllegalStateException("Exceeds MAX LENGTH");
            else if (!StringUtils.isEmpty((String) bookingBody.get(ADDRESS_LINE_2)))
                addressLine2 = (String) bookingBody.get(ADDRESS_LINE_2);
        } catch (Exception e) {
            System.out.println("Bad_request.BOOKING_ADDRESS_LINE_2_INVALID_VALUE");
            Errors errors = new Errors("E-0-0", e.getMessage());
            throw new BookingSytemException(e.getMessage(), errors);
        }
        if (null != addressLine2)
            booking.setAddressLine2(addressLine2);
    }

    private void validateCity(Map<String, Object> bookingBody, Booking booking) throws BookingSytemException {
        String city = null;
        try {
            if (!StringUtils.isEmpty((String) bookingBody.get(CITY)) && ((String) bookingBody.get(CITY)).length() > 255)
                throw new IllegalStateException("Exceeds MAX LENGTH");
            else if (!StringUtils.isEmpty((String) bookingBody.get(CITY)))
                city = (String) bookingBody.get(CITY);
        } catch (Exception e) {
            System.out.println("Bad_request.BOOKING_CITY_INVALID_VALUE");
            Errors errors = new Errors("E-0-0", e.getMessage());
            throw new BookingSytemException(e.getMessage(), errors);
        }
        if (null == city) {
            System.out.println("Bad_request.BOOKING_CITY_REQUIRED_VALUE");
            Errors errors = new Errors("E-0-1", CITY + REQUIRED);
            throw new BookingSytemException(REQUIRED, errors);
        } else
            booking.setCity(city);
    }

    private void validateState(Map<String, Object> bookingBody, Booking booking) throws BookingSytemException {
        String state = null;
        try {
            if (!StringUtils.isEmpty((String) bookingBody.get(STATE)) && ((String) bookingBody.get(STATE)).length() > 255)
                throw new IllegalStateException("Exceeds MAX LENGTH");
            else if (!StringUtils.isEmpty((String) bookingBody.get(STATE)))
                state = (String) bookingBody.get(STATE);
        } catch (Exception e) {
            System.out.println("Bad_request.BOOKING_STATE_INVALID_VALUE");
            Errors errors = new Errors("E-0-0", e.getMessage());
            throw new BookingSytemException(e.getMessage(), errors);
        }
        if (null == state) {
            System.out.println("Bad_request.BOOKING_STATE_REQUIRED_VALUE");
            Errors errors = new Errors("E-0-1", STATE + REQUIRED);
            throw new BookingSytemException(REQUIRED, errors);
        } else
            booking.setState(state);
    }


    private void validateCountry(Map<String, Object> bookingBody, Booking booking) throws BookingSytemException {
        String country = null;
        try {
            if (!StringUtils.isEmpty((String) bookingBody.get(COUNTRY)) && ((String) bookingBody.get(COUNTRY)).length() > 255)
                throw new IllegalStateException("Exceeds MAX LENGTH");
            else if (!StringUtils.isEmpty((String) bookingBody.get(COUNTRY)))
                country = (String) bookingBody.get(COUNTRY);
        } catch (Exception e) {
            System.out.println("Bad_request.BOOKING_COUNTRY_INVALID_VALUE");
            Errors errors = new Errors("E-0-0", e.getMessage());
            throw new BookingSytemException(e.getMessage(), errors);
        }
        if (null == country) {
            System.out.println("Bad_request.BOOKING_COUNTRY_REQUIRED_VALUE");
            Errors errors = new Errors("E-0-1", COUNTRY + REQUIRED);
            throw new BookingSytemException(REQUIRED, errors);
        } else
            booking.setCountry(country);
    }

    private void validateZipCode(Map<String, Object> bookingBody, Booking booking) throws BookingSytemException {
        String zipCode = null;
        try {
            if (!StringUtils.isEmpty((String) bookingBody.get(ZIP_CODE)) && ((String) bookingBody.get(ZIP_CODE)).length() > 10)
                throw new IllegalStateException("Exceeds MAX LENGTH");
            else if (!StringUtils.isEmpty((String) bookingBody.get(ZIP_CODE)))
                zipCode = (String) bookingBody.get(ZIP_CODE);
        } catch (Exception e) {
            System.out.println("Bad_request.BOOKING_ZIP_CODE_INVALID_VALUE");
            Errors errors = new Errors("E-0-0", e.getMessage());
            throw new BookingSytemException(e.getMessage(), errors);
        }
        if (null == zipCode) {
            System.out.println("Bad_request.BOOKING_ZIP_CODE_REQUIRED_VALUE");
            Errors errors = new Errors("E-0-1", ZIP_CODE + REQUIRED);
            throw new BookingSytemException(REQUIRED, errors);
        } else
            booking.setZipCode(zipCode);
    }

}
