package com.flightbooking.service;

import java.util.List;

import com.flightbooking.exception.FlightNotFoundException;
import com.flightbooking.model.Flight;

public interface FlightService {
	public Flight addFlight(Flight flight);
	public Flight updateFlight(Flight flight, long flightId)throws FlightNotFoundException;
	public List<Flight> getAllFlights();
	public Flight getFlightById(long flightId) throws FlightNotFoundException;
	
	public List<Flight> getFlightByDestination(String destination) throws FlightNotFoundException;
	
}
