package com.flightbooking.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.exception.BookingAlreadyExistsException;
import com.flightbooking.exception.BookingNotFoundException;
import com.flightbooking.model.Booking;
import com.flightbooking.repository.BookingRepository;
import com.flightbooking.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepository repository;
	
	
	public List<Booking> getAllBookings() {
		return repository.findAll();
	}

	
	public Booking newBooking(Booking booking) throws BookingAlreadyExistsException {
		if(repository.existsById(booking.getBookingId())) {
			throw new BookingAlreadyExistsException();
		}
		return repository.save(booking);
	}

	
	public void cancelBooking(long bookingId) throws BookingNotFoundException {
		
		if(repository.existsById(bookingId)) {
			Booking book=repository.getOne( bookingId);
			repository.delete(book);
			
		}
		else
			throw new BookingNotFoundException();
		
	}

	public Booking findByBookingId(long bookingId)throws BookingNotFoundException {
		Booking book;
		if(repository.findById(bookingId).isEmpty()) {
			throw new BookingNotFoundException();
		}
		else {
			book= repository.findById(bookingId).get();
		}
		return book;
	}
	
}
