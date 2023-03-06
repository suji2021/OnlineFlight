package com.flightbooking.service;

import java.util.List;

import com.flightbooking.model.Ticket;

public interface TicketService {
	
	public Ticket addTicket(Ticket ticket);
	public List<Ticket> findAllTickets();
	public Ticket getTicketById(int ticketId);
	public void cancelTicket(int ticketId);
}
