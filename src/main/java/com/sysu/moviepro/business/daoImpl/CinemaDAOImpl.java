package com.sysu.moviepro.business.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sysu.moviepro.business.dao.CinemaDAO;
import com.sysu.moviepro.business.entity.Cinema;

@Repository
public class CinemaDAOImpl implements CinemaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int createCinema(Cinema Cinema) {
		// TODO Auto-generated method stub
		Integer id = (Integer) sessionFactory.getCurrentSession().save(Cinema);
		return id;
	}

	@Override
	public Cinema updateCinema(Cinema Cinema) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(Cinema);
		sessionFactory.getCurrentSession().flush();
		return Cinema;
	}

	@Override
	public void deleteCinema(int id) {
		// TODO Auto-generated method stub
		Cinema Cinema = new Cinema();
		Cinema.setId(id);
		sessionFactory.getCurrentSession().delete(Cinema);
	}

	@Override
	public Cinema getCinema(int id) {
		// TODO Auto-generated method stub
		Cinema Cinema = (Cinema) sessionFactory.getCurrentSession().get(Cinema.class, id);
		return Cinema;
	}
	
	@Override
	public Cinema getCinemaByName(String name) {
		String hql = "select Cinema.id from Cinema Cinema where Cinema.name = '" + name + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List list = query.list();
		assert(list.size() <= 1);
		if (list.isEmpty())
			return new Cinema();
		else {
			int id = (Integer)list.get(0);
			return getCinema(id);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cinema> getAllCinemas() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(" From Cinema Cinema ").list();
	}
}
