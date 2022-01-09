import com.paypal.bfs.test.bookingservImpl.dao.BookingRepository;
import com.paypal.bfs.test.bookingservImpl.model.Booking;
import com.paypal.bfs.test.bookingservImpl.service.BookingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(ServiceLayerTest.class)
public class ServiceLayerTest {
    @InjectMocks
    BookingService bookingService;

    @Mock
    BookingRepository bookingRepository;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(bookingService).build();
    }

    @Test
    public void createServiceShouldReturnTrue() throws Exception {
        when(bookingRepository.save(any(Booking.class))).thenReturn(new Booking());
        Assert.assertTrue(bookingService.create(new Booking()));
    }

    @Test
    public void createServiceShouldReturnFalse() throws Exception {
        when(bookingRepository.save(any(Booking.class))).thenReturn(null);
        Assert.assertFalse(bookingService.create(new Booking()));
    }

    @Test
    public void getAllBookingShoulReturnList() throws Exception {
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
        List<Booking> listOfAllBookings = new ArrayList<>();
        listOfAllBookings.add(booking2);
        listOfAllBookings.add(booking2);
        when(bookingRepository.findAll()).thenReturn(listOfAllBookings);
        Assert.assertThat(bookingService.getAllRecords().size(), is(2));
    }
}
