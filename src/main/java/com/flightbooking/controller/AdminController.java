package com.flightbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.exception.AirportNotFoundException;
import com.flightbooking.exception.FlightNotFoundException;
import com.flightbooking.exception.InvalidAdminException;
import com.flightbooking.model.Admin;
import com.flightbooking.model.Airport;
import com.flightbooking.model.Booking;
import com.flightbooking.model.Flight;
import com.flightbooking.model.Ticket;
import com.flightbooking.model.User;
import com.flightbooking.service.AdminService;
import com.flightbooking.service.AirportService;
import com.flightbooking.service.BookingService;
import com.flightbooking.service.FlightService;
import com.flightbooking.service.TicketService;
import com.flightbooking.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AirportService airportService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;
	
	//Administrator part
	
	@PostMapping("/adminRegistration")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
		Admin f=this.adminService.registerAdmin(admin);
		return new ResponseEntity<>(f, HttpStatus.CREATED);
	}
	
	@PostMapping("/loginAdmin") String loginAdmin(@RequestBody Admin admin) throws InvalidAdminException{
		return this.adminService.loginAdmin(admin);
	}

	//Airport
	
	@PostMapping("/addAirports")
	public Airport addAirport(@RequestBody Airport airport) {
		return this.airportService.addAirport(airport);
	}

	
		@GetMapping("/getAllAirports")
		public List<Airport> getAllAirports() {
			return airportService.getAllAirport();
		}

		
		@PutMapping("/updateAirport/{airportId}")
		public Airport updateAirport(@RequestBody Airport airport, @PathVariable long airportId) throws AirportNotFoundException {
			return this.airportService.updateAirport(airport, airportId);
		}
		

	
	//Flight part
	
	@PostMapping("/addFlight")
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
		Flight ft=this.flightService.addFlight(flight);
		return new ResponseEntity<>(ft, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateFlight/{flightId}")
	public Flight updateFlight(@RequestBody Flight flight, @PathVariable long flightId) throws FlightNotFoundException {
		return this.flightService.updateFlight(flight,flightId);
	}
	
	@GetMapping("/getAllFlights")
	public List<Flight> getAllFlights() {
		return this.flightService.getAllFlights();
	}
	
	@GetMapping("/getFlightById/{flightId}")
	public ResponseEntity<Flight> getFlight(@PathVariable long flightId) throws FlightNotFoundException {
		return new ResponseEntity<>(this.flightService.getFlightById(flightId),HttpStatus.OK);
	}
	
	
	//user 
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}
	
	// booking part
	
			@GetMapping("/getAllBookings")
			public List<Booking> getAllBookings(){
				return this.bookingService.getAllBookings();
			}
			
	//Ticket part
		
		@PostMapping("/addTicket")
		public Ticket addTicket(@RequestBody Ticket ticket) {
			return this.ticketService.addTicket(ticket);
		}
		
		@GetMapping("/FindAllTickets")
		public List<Ticket> findAllTickets() {
			return this.ticketService.findAllTickets();
		}
		
		@DeleteMapping("/cancelTicket/{ticketId}")
		public ResponseEntity<String> cancelTicket(@PathVariable int ticket) {
			this.ticketService.getTicketById(ticket);
			this.ticketService.cancelTicket(ticket);
			return new ResponseEntity<>("Cancelled Successfully",HttpStatus.OK);
		}
		
}
