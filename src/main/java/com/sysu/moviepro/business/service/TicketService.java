package com.sysu.moviepro.business.service;

import java.util.List;

import com.sysu.moviepro.business.entity.Ticket;

public interface TicketService {
	public int createTicket(Ticket Ticket);
	public Ticket updateTicket(Ticket Ticket);
	public void deleteTicket(int id);
	public Ticket getTicket(int id);
	public Ticket getTicketByName(String name);
	public List<Ticket> getAllTickets(); 
}
