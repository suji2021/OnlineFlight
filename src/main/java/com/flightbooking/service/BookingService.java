package com.flightbooking.service;

import java.util.List;

import com.flightbooking.exception.BookingNotFoundException;
import com.flightbooking.model.Booking;
public interface BookingService {
	
	public List<Booking> getAllBookings();
	public Booking newBooking(Booking booking);
	public void cancelBooking(long bookingId)throws BookingNotFoundException;
	public Booking findByBookingId(long bookingId) throws BookingNotFoundException;
	
}
