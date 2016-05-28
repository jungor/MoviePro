package com.sysu.moviepro.business.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sysu.moviepro.business.dao.MovieDAO;
import com.sysu.moviepro.business.entity.Movie;

@Repository
public class MovieDAOImpl implements MovieDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int createMovie(Movie movie) {
		// TODO Auto-generated method stub
		Integer id = (Integer) sessionFactory.getCurrentSession().save(movie);
		return id;
	}

	@Override
	public Movie updateMovie(Movie Movie) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(Movie);
		return Movie;
	}

	@Override
	public void deleteMovie(int id) {
		// TODO Auto-generated method stub
		Movie Movie = new Movie();
		Movie.setId(id);
		sessionFactory.getCurrentSession().delete(Movie);
	}

	@Override
	public Movie getMovie(int id) {
		// TODO Auto-generated method stub
		Movie Movie = (Movie) sessionFactory.getCurrentSession().get(Movie.class, id);
		return Movie;
	}
	
	@Override
	public Movie getMovieByName(String name) {
		String hql = "select Movie.id from Movie movie where movie.name = '" + name + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		Movie Movie = (Movie) sessionFactory.getCurrentSession().get(Movie.class, name);
		return Movie;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(" From Movie movie ").list();
	}
}
