package com.sysu.moviepro.business.serviceImpl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sysu.moviepro.business.entity.Seat;
import com.sysu.moviepro.business.entity.Ticket;
import com.sysu.moviepro.business.service.TicketService;
import com.sysu.moviepro.business.dao.TicketDAO;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

	public TicketServiceImpl() {
		System.out.println("TicketServiceImpl()");
	}

	@Autowired
	private TicketDAO TicketDAO;
	
	@Override
	public int createTicket(Ticket Ticket) {
		// TODO Auto-generated method stub
		return TicketDAO.createTicket(Ticket);
	}

	@Override
	public Ticket updateTicket(Ticket Ticket) {
		// TODO Auto-generated method stub
		return TicketDAO.updateTicket(Ticket);
	}

	@Override
	public void deleteTicket(int id) {
		// TODO Auto-generated method stub
		TicketDAO.deleteTicket(id);
	}

	@Override
	public Ticket getTicket(int id) {
		// TODO Auto-generated method stub
		return TicketDAO.getTicket(id);
	}

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return TicketDAO.getAllTickets();
	}

	@Override
	public Ticket createTicketBySeat(Seat seat) {
		// TODO Auto-generated method stub
		Ticket ticket = new Ticket();
		ticket.setSoldDate(Calendar.getInstance());
		ticket.setSeat(seat);
		ticket.setPrice(seat.getPrice());
		//int id = TicketDAO.createTicket(ticket);
		return ticket;
	}
}
