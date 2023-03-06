package com.flightbooking;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.flightbooking.exception.BookingAlreadyExistsException;
import com.flightbooking.exception.BookingNotFoundException;
import com.flightbooking.model.Booking;
import com.flightbooking.service.BookingService;
@RunWith(MockitoJUnitRunner.class)
public class BookingTest {
	@Mock
	private BookingService bookingService;
	private Booking booking;
	@Before
	public void setup() {
	booking= new Booking();
	booking.setBookingId(1);
	}
	
	@Test
	public void testGetAllBookings() {
	List<Booking> expectedBookings = new ArrayList<>();
	expectedBookings.add(booking);
	 when(bookingService.getAllBookings()).thenReturn(expectedBookings);
	List<Booking> actualBookings = bookingService.getAllBookings();
	assertNotNull(actualBookings);
	assertEquals(expectedBookings.size(), actualBookings.size());
	 assertEquals(expectedBookings.get(0), actualBookings.get(0));
	 }
	
	@Test
	public void testNewBooking() throws BookingAlreadyExistsException {
	 when(bookingService.newBooking(booking)).thenReturn(booking);
	Booking actualBooking = bookingService.newBooking(booking);
	assertNotNull(actualBooking);
	assertEquals(booking, actualBooking);
	}
	
	@Test
	public void testCancelBooking() throws BookingNotFoundException {
	bookingService.cancelBooking(booking.getBookingId());
	}
	
	@Test
	public void testFindByBookingId() throws BookingNotFoundException {
		when(bookingService.findByBookingId(booking.getBookingId())).thenReturn(booking);
		Booking actualBooking = bookingService.findByBookingId(booking.getBookingId());
		assertNotNull(actualBooking);
		assertEquals(booking, actualBooking);
		}	
	}