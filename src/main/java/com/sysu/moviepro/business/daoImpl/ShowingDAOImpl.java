package com.sysu.moviepro.business.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sysu.moviepro.business.dao.ShowingDAO;
import com.sysu.moviepro.business.entity.Showing;

@Repository
public class ShowingDAOImpl implements ShowingDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int createShowing(Showing showing) {
		// TODO Auto-generated method stub
		Integer id = (Integer) sessionFactory.getCurrentSession().save(showing);
		return id;
	}

	@Override
	public Showing updateShowing(Showing showing) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(showing);
		sessionFactory.getCurrentSession().flush();
		return showing;
	}

	@Override
	public void deleteShowing(int id) {
		// TODO Auto-generated method stub
		Showing showing = new Showing();
		showing.setId(id);
		sessionFactory.getCurrentSession().delete(showing);
	}

	@Override
	public Showing getShowing(int id) {
		// TODO Auto-generated method stub
		Showing showing = (Showing) sessionFactory.getCurrentSession().get(Showing.class, id);
		return showing;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Showing> getAllShowings() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From Showing showing").list();
	}

	@Override
	public List<Showing> getShowingsByMovieAndCinema(int movie_id, int cinema_id) {
		// TODO Auto-generated method stub
		String hql = "select showing.id from Showing showing where showing.movie.id = "+ movie_id + " and showing.cinema.id = "+cinema_id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List list = query.list();
		List<Showing> showings = new ArrayList<Showing>(); 
		for (Object id: list) {
			showings.add(getShowing((Integer)id));
		}
		return showings;
	}

}
