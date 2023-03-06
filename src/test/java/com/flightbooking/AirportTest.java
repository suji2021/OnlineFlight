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

import com.flightbooking.model.Airport;
import com.flightbooking.service.AirportService;

@RunWith(MockitoJUnitRunner.class)
public class AirportTest {

    @Mock
    private AirportService airportService;
    private Airport airport;

    @Before
	public void setup() {
	airport= new Airport();
	airport.setAirportId(1);
	}

	@Test
    public void testGetAllAirports() {
		List<Airport> expectedAirports = new ArrayList<>();
		expectedAirports.add(airport);
		 when(airportService.getAllAirport()).thenReturn(expectedAirports);
		List<Airport> actualAirports = airportService.getAllAirport();
		assertNotNull(actualAirports);
		assertEquals(expectedAirports.size(), actualAirports.size());
		 assertEquals(expectedAirports.get(0), actualAirports.get(0));
        
    }
	
	@Test
	public void testAddAirport() {
	 when(airportService.addAirport(airport)).thenReturn(airport);
	Airport actualAirport =airportService.addAirport(airport);
	assertNotNull(actualAirport);
	assertEquals(airport, actualAirport);
	}
	
	
}
