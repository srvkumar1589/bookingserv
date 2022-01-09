import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.paypal.bfs.test.bookingservImpl.impl.BookingResourceImpl;
import com.paypal.bfs.test.bookingservImpl.inputvalidator.BookingInputValidator;
import com.paypal.bfs.test.bookingservImpl.model.Booking;
import com.paypal.bfs.test.bookingservImpl.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(BookingResourceImpl.class)
public class WebLayerTest {

    @Mock
    private BookingService service;

    @Mock
    private BookingInputValidator bookingInputValidator;

    @InjectMocks
    private BookingResourceImpl bookingResource;

    MockMvc mockMvc;
    String url;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(bookingResource).build();
        url = "/v1/bfs/booking";
    }

    @Test
    public void creatingBookingShouldBeSucessful() throws Exception {
        Booking booking = new Booking();
        booking.setId(1);
        booking.setDateOfBirth("1997-06-21");
        booking.setCheckinDatetime(new Date(2000, 01, 01, 9, 9, 9));
        booking.setCheckoutDatetime(new Date(2001, 01, 01, 9, 9, 9));
        booking.setFirstName("Sourav");
        booking.setLastName("Kumar");
        booking.setAddressLine1("12/1 CC lane");
        booking.setCity("Kolkata");
        booking.setState("West Bengal");
        booking.setCountry("India");
        booking.setZipCode("700035");
        booking.setTotalPrice(2302.09);
        booking.setDeposit(253.1);
        long checkInDateInMilis = booking.getCheckinDatetime().getTime();
        long checkOutDateInMilis = booking.getCheckoutDatetime().getTime();
        when(service.create(any(Booking.class))).thenReturn(true);
        when(bookingInputValidator.validateBookingFields(any(Map.class))).thenReturn(booking);
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(booking);

        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.first_name", is("Sourav")))
                .andExpect(jsonPath("$.last_name", is("Kumar")))
                .andExpect(jsonPath("$.date_of_birth", is("1997-06-21")))
                .andExpect(jsonPath("$.checkin_datetime", is(checkInDateInMilis)))
                .andExpect(jsonPath("$.checkout_datetime", is(checkOutDateInMilis)))
                .andExpect(jsonPath("$.total_price", is(2302.09)))
                .andExpect(jsonPath("$.deposit", is(253.1)))
                .andExpect(jsonPath("$.address_line1", is("12/1 CC lane")))
                .andExpect(jsonPath("$.city", is("Kolkata")))
                .andExpect(jsonPath("$.state", is("West Bengal")))
                .andExpect(jsonPath("$.country", is("India")))
                .andExpect(jsonPath("$.zip_code", is("700035")))
        ;
    }

    @Test
    public void sameResourceSavingShouldReturnAnError() throws Exception {
        Booking booking = new Booking();
        booking.setId(1);
        booking.setDateOfBirth("1997-06-21");
        booking.setCheckinDatetime(new Date(2000, 01, 01, 9, 9, 9));
        booking.setCheckoutDatetime(new Date(2001, 01, 01, 9, 9, 9));
        booking.setFirstName("Sourav");
        booking.setLastName("Kumar");
        booking.setAddressLine1("12/1 CC lane");
        booking.setCity("Kolkata");
        booking.setState("West Bengal");
        booking.setCountry("India");
        booking.setZipCode("700035");
        booking.setTotalPrice(2302.09);
        booking.setDeposit(253.1);
        long checkInDateInMilis = booking.getCheckinDatetime().getTime();
        long checkOutDateInMilis = booking.getCheckoutDatetime().getTime();
        when(service.create(any(Booking.class))).thenReturn(true);
        when(bookingInputValidator.validateBookingFields(any(Map.class))).thenReturn(booking);
        when(service.findById(booking.getId() + "")).thenReturn(Optional.empty());
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(booking);
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isCreated());

        when(service.findById(booking.getId() + "")).thenReturn(Optional.of(booking));
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isForbidden())
                .andExpect(content().string("Booking record Exists!"));
    }

    @Test
    public void getAllBookingShouldBeSucessful() throws Exception {
        Booking booking = new Booking();
        booking.setId(1);
        booking.setDateOfBirth("1997-06-21");
        booking.setCheckinDatetime(new Date(2000, 01, 01, 9, 9, 9));
        booking.setCheckoutDatetime(new Date(2001, 01, 01, 9, 9, 9));
        booking.setFirstName("Sourav");
        booking.setLastName("Kumar");
        booking.setAddressLine1("12/1 CC lane");
        booking.setCity("Kolkata");
        booking.setState("West Bengal");
        booking.setCountry("India");
        booking.setZipCode("700035");
        booking.setTotalPrice(2302.09);
        booking.setDeposit(253.1);
        long checkInDateInMilis = booking.getCheckinDatetime().getTime();
        long checkOutDateInMilis = booking.getCheckoutDatetime().getTime();

        Booking booking2 = new Booking();
        booking2.setId(2);
        booking2.setDateOfBirth("2007-06-21");
        booking2.setCheckinDatetime(new Date(2000, 01, 01, 9, 9, 9));
        booking2.setCheckoutDatetime(new Date(2001, 01, 01, 9, 9, 9));
        booking2.setFirstName("Sanjib");
        booking2.setLastName("Kumar");
        booking2.setAddressLine1("12/1 CC lane");
        booking2.setCity("Kolkata");
        booking2.setState("West Bengal");
        booking2.setCountry("India");
        booking2.setZipCode("700035");
        booking2.setTotalPrice(1000.00);
        booking2.setDeposit(200.00);
        long checkInDateInMilis2 = booking2.getCheckinDatetime().getTime();
        long checkOutDateInMilis2 = booking2.getCheckoutDatetime().getTime();

        List<Booking> listOfAllBookings = new ArrayList<>();
        listOfAllBookings.add(booking);
        listOfAllBookings.add(booking2);
        when(service.getAllRecords()).thenReturn(listOfAllBookings);
        mockMvc.perform(get(url)).andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id", is(1)))
                .andExpect(jsonPath("$.[0].first_name", is("Sourav")))
                .andExpect(jsonPath("$.[0].last_name", is("Kumar")))
                .andExpect(jsonPath("$.[0].date_of_birth", is("1997-06-21")))
                .andExpect(jsonPath("$.[0].checkin_datetime", is(checkInDateInMilis)))
                .andExpect(jsonPath("$.[0].checkout_datetime", is(checkOutDateInMilis)))
                .andExpect(jsonPath("$.[0].total_price", is(2302.09)))
                .andExpect(jsonPath("$.[0].deposit", is(253.1)))
                .andExpect(jsonPath("$.[0].address_line1", is("12/1 CC lane")))
                .andExpect(jsonPath("$.[0].city", is("Kolkata")))
                .andExpect(jsonPath("$.[0].state", is("West Bengal")))
                .andExpect(jsonPath("$.[0].country", is("India")))
                .andExpect(jsonPath("$.[0].zip_code", is("700035")))

                .andExpect(jsonPath("$.[1].id", is(2)))
                .andExpect(jsonPath("$.[1].first_name", is("Sanjib")))
                .andExpect(jsonPath("$.[1].last_name", is("Kumar")))
                .andExpect(jsonPath("$.[1].date_of_birth", is("2007-06-21")))
                .andExpect(jsonPath("$.[1].checkin_datetime", is(checkInDateInMilis2)))
                .andExpect(jsonPath("$.[1].checkout_datetime", is(checkOutDateInMilis2)))
                .andExpect(jsonPath("$.[1].total_price", is(1000.00)))
                .andExpect(jsonPath("$.[1].deposit", is(200.00)))
                .andExpect(jsonPath("$.[1].address_line1", is("12/1 CC lane")))
                .andExpect(jsonPath("$.[1].city", is("Kolkata")))
                .andExpect(jsonPath("$.[1].state", is("West Bengal")))
                .andExpect(jsonPath("$.[1].country", is("India")))
                .andExpect(jsonPath("$.[1].zip_code", is("700035")))
        ;
    }

}
