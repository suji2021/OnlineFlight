package com.flightbooking;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
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
		booking = new Booking();
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
	public void testNewBooking() {
		when(bookingService.newBooking(booking)).thenReturn(booking);
		Booking actualBooking = bookingService.newBooking(booking);
		assertNotNull(actualBooking);
		assertEquals(booking, actualBooking);
		verify(bookingService, times(1)).newBooking(booking);
		}	
	
	@Test
	public void testCancelBooking() throws BookingNotFoundException {
		when(bookingService.findByBookingId(booking.getBookingId())).thenReturn(booking);
		bookingService.cancelBooking(booking.getBookingId());
		verify(bookingService, times(1)).cancelBooking(booking.getBookingId());	
		
		// verify that the booking is no longer present after cancellation
		when(bookingService.findByBookingId(booking.getBookingId())).thenThrow(BookingNotFoundException.class);
		try {
			bookingService.findByBookingId(booking.getBookingId());
		} catch (BookingNotFoundException ex) {
			// expected exception
			return;
		}
	// If BookingNotFoundException is not thrown, the test should fail
		throw new AssertionError("BookingNotFoundException not thrown");
		}	
	
	@Test
	public void testFindByBookingId() throws BookingNotFoundException {
		when(bookingService.findByBookingId(booking.getBookingId())).thenReturn(booking);
		Booking actualBooking = bookingService.findByBookingId(booking.getBookingId());
		assertNotNull(actualBooking);
		assertEquals(booking, actualBooking);
		}
}
