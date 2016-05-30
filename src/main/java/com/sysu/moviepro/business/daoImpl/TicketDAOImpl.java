package com.sysu.moviepro.business.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sysu.moviepro.business.dao.TicketDAO;
import com.sysu.moviepro.business.entity.Ticket;

@Repository
public class TicketDAOImpl implements TicketDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int createTicket(Ticket Ticket) {
		// TODO Auto-generated method stub
		Integer id = (Integer) sessionFactory.getCurrentSession().save(Ticket);
		return id;
	}

	@Override
	public Ticket updateTicket(Ticket Ticket) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(Ticket);
		sessionFactory.getCurrentSession().flush();
		return Ticket;
	}

	@Override
	public void deleteTicket(int id) {
		// TODO Auto-generated method stub
		Ticket Ticket = new Ticket();
		Ticket.setId(id);
		sessionFactory.getCurrentSession().delete(Ticket);
	}

	@Override
	public Ticket getTicket(int id) {
		// TODO Auto-generated method stub
		Ticket Ticket = (Ticket) sessionFactory.getCurrentSession().get(Ticket.class, id);
		return Ticket;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(" From Ticket Ticket ").list();
	}
}
