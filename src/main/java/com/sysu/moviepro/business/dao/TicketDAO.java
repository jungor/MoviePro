package com.sysu.moviepro.business.dao;

import com.sysu.moviepro.business.entity.Ticket;

import java.util.List;

public interface TicketDAO {
	public int createTicket(Ticket ticket);
	public Ticket updateTicket(Ticket ticket);
	public void deleteTicket(int id);
	public Ticket getTicket(int id);
	public List<Ticket> getAllTickets();
}
