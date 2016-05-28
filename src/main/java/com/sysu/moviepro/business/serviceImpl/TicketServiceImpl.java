package com.sysu.moviepro.business.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Ticket getTicketByName(String name) {
		return TicketDAO.getTicketByName(name);
	}

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return TicketDAO.getAllTickets();
	}
}
