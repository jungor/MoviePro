package com.sysu.moviepro.business.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sysu.moviepro.business.dao.ScreeningRoomDAO;
import com.sysu.moviepro.business.entity.ScreeningRoom;

@Repository
public class ScreeningRoomDAOImpl implements ScreeningRoomDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int createScreeningRoom(ScreeningRoom screeningRoom) {
		// TODO Auto-generated method stub
		Integer id = (Integer) sessionFactory.getCurrentSession().save(screeningRoom); 
		return id;
	}

	@Override
	public ScreeningRoom updateScreenRoom(ScreeningRoom screeningRoom) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(screeningRoom);
		sessionFactory.getCurrentSession().flush();
		return screeningRoom;
	}

	@Override
	public void deleteScreenRoom(int id) {
		// TODO Auto-generated method stub
		ScreeningRoom screeningRoom = new ScreeningRoom();
		screeningRoom.setId(id);
		sessionFactory.getCurrentSession().delete(screeningRoom);
	}

	@Override
	public ScreeningRoom getScreeningRoom(int id) {
		// TODO Auto-generated method stub
		ScreeningRoom screeningRoom = (ScreeningRoom) sessionFactory.getCurrentSession().get(ScreeningRoom.class, id);
		return screeningRoom;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ScreeningRoom> getAllScreeningRooms() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From ScreeningRoom screeningroom ").list();
	}
}
