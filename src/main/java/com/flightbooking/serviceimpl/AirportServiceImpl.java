package com.flightbooking.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.exception.AirportNotFoundException;
import com.flightbooking.model.Airport;
import com.flightbooking.repository.AirportRepository;
import com.flightbooking.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService{

	@Autowired
	private AirportRepository repository;

	
	public List<Airport> getAllAirport() {
		return repository.findAll();
	}

	
	public Airport addAirport(Airport airport) {
		return repository.save(airport);
	}

	
	public Airport updateAirport(Airport airport, long airportId) throws AirportNotFoundException {
		Optional<Airport> airports=repository.findById(airportId);
		if(airports.isPresent()) {
			Airport a =repository.getOne(airportId);
			a.setAirportName(airport.getAirportName());
			a.setCity(airport.getCity());
			return this.repository.save(a);
			
		}		
		throw new AirportNotFoundException();
	}
	
}


