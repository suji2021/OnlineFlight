package com.flightbooking.service;

import java.util.List;

import com.flightbooking.exception.AirportNotFoundException;
import com.flightbooking.model.Airport;

public interface AirportService {
	public List<Airport> getAllAirport();
	public Airport addAirport(Airport airport);
	public Airport updateAirport(Airport airport, long airportId)throws AirportNotFoundException;
	
}
