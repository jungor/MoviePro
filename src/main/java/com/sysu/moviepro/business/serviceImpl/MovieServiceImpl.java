package com.sysu.moviepro.business.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sysu.moviepro.business.dao.MovieDAO;
import com.sysu.moviepro.business.entity.Movie;
import com.sysu.moviepro.business.service.MovieService;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	public MovieServiceImpl() {
		System.out.println("MovieServiceImpl()");
	}

	@Autowired
	private MovieDAO MovieDAO;

	@Override
	public int createMovie(Movie Movie) {
		// TODO Auto-generated method stub
		return MovieDAO.createMovie(Movie);
	}

	@Override
	public Movie updateMovie(Movie Movie) {
		// TODO Auto-generated method stub
		return MovieDAO.updateMovie(Movie);
	}

	@Override
	public void deleteMovie(int id) {
		// TODO Auto-generated method stub
		MovieDAO.deleteMovie(id);
	}

	@Override
	public Movie getMovie(int id) {
		// TODO Auto-generated method stub
		return MovieDAO.getMovie(id);
	}
	
	@Override
	public Movie getMovieByName(String name) {
		return MovieDAO.getMovieByName(name);
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return MovieDAO.getAllMovies();
	}
}
