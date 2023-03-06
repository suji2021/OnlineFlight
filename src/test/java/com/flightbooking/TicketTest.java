package com.flightbooking;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.flightbooking.model.Ticket;
import com.flightbooking.service.TicketService;
public class TicketTest {
	@Mock
	private TicketService ticketServiceMock;
	@Before
	public void setUp() {
	MockitoAnnotations.initMocks(this);
}
	
	@Test
	public void testFindAllTickets() {
	List<Ticket> expectedTickets = new ArrayList<>();
	expectedTickets.add(new Ticket());
	expectedTickets.add(new Ticket());
	when(ticketServiceMock.findAllTickets()).thenReturn(expectedTickets);	
	List<Ticket> actualTickets = ticketServiceMock.findAllTickets();
	assertEquals(expectedTickets, actualTickets);
	}	
	
	@Test
	public void testAddTicket() {
	Ticket expectedTickets = new Ticket();
	when(ticketServiceMock.addTicket(expectedTickets)).thenReturn(expectedTickets);
	Ticket actualTickets = ticketServiceMock.addTicket(expectedTickets);
	assertEquals(expectedTickets, actualTickets);
	}	

}