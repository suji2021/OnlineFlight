package com.flightbooking.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.model.Ticket;
import com.flightbooking.repository.TicketRepository;
import com.flightbooking.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository repository;
		
	public List<Ticket> findAllTickets() {
		return this.repository.findAll();
	}
	
	public Ticket addTicket(Ticket ticket) {
		return repository.save(ticket) ;
	}

	public Ticket getTicketById(int ticketId) {	
		return this.repository.findById(ticketId).orElse(null);
	}

	
	public void cancelTicket(int ticketId) {
		Ticket tic = repository.getOne(ticketId);
		repository.delete(tic);
	}
	
	
}
