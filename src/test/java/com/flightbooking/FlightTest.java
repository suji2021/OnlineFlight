package com.flightbooking;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.flightbooking.controller.AdminController;
import com.flightbooking.exception.FlightNotFoundException;
import com.flightbooking.model.Flight;
import com.flightbooking.service.FlightService;

public class FlightTest {
	@InjectMocks
	private AdminController adminController;
	@Test
	public void testGetAllFlights() {
	FlightService flightService= mock(FlightService.class);
	List<Flight> expectedFlights = new ArrayList<>();
	expectedFlights.add(new Flight());
	expectedFlights.add(new Flight());
	when(flightService.getAllFlights()).thenReturn(expectedFlights);
	List<Flight> actualFlights = flightService.getAllFlights();
	assertEquals(expectedFlights, actualFlights);
	}
	
	@Test
	public void testUpdateFlight() throws FlightNotFoundException {
	FlightService flightService= mock(FlightService.class);
	Flight flightToUpdate = new Flight();
	Flight updatedFlight = new Flight();
	when(flightService.updateFlight(flightToUpdate, 0)).thenReturn(updatedFlight);
	Flight actualFlight = flightService.updateFlight(flightToUpdate, 0);
	assertEquals(updatedFlight, actualFlight);
	}
}
