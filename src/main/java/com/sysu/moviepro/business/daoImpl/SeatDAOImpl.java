package com.sysu.moviepro.business.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sysu.moviepro.business.dao.SeatDAO;
import com.sysu.moviepro.business.entity.Seat;

@Repository
public class SeatDAOImpl implements SeatDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int createSeat(Seat seat) {
		// TODO Auto-generated method stub
		Integer id = (Integer) sessionFactory.getCurrentSession().save(seat);
		return id;
	}

	@Override
	public Seat updateSeat(Seat seat) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(seat);
		sessionFactory.getCurrentSession().flush();
		return seat;
	}

	@Override
	public void deleteSeat(int id) {
		// TODO Auto-generated method stub
		Seat seat = new Seat();
		seat.setId(id);
		sessionFactory.getCurrentSession().delete(seat);
	}

	@Override
	public Seat getSeat(int id) {
		// TODO Auto-generated method stub
		Seat seat = (Seat) sessionFactory.getCurrentSession().get(Seat.class, id);
		return seat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Seat> getAllSeats() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From Seat seat").list();
	}

	@Override
	public List<Seat> getAllSeatsByScreeningRoom(int sc_id) {
		// TODO Auto-generated method stub
		String hql = "select seat.id from Seat seat where seat.screeningRoom.id = "+ sc_id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List list = query.list();
		List<Seat> seats = new ArrayList<Seat>(); 
		for (Object id: list) {
			seats.add(getSeat((Integer)id));
		}
		return seats;
	}

	@Override
	public void updateSeatStatus(int id, boolean status) {
		// TODO Auto-generated method stub
		String hql = "update Seat s set s.sold = " + status + " where s.id =" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
	}

	@Override
	public Seat getSeatByRowAndCol(int rowNumber, int colNumber, int sc_id) {
		// TODO Auto-generated method stub
		String hql = "select seat.id from Seat seat where seat.rowNumber = "+ rowNumber 
				+ " and seat.colNumber = "+ colNumber 
				+ " and seat.screeningRoom.id = " +sc_id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List list = query.list();
		assert(list.size() <= 1);
		int id = (Integer)list.get(0);
		return getSeat(id);
	}

}
