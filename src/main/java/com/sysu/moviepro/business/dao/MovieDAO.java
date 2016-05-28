package com.sysu.moviepro.business.dao;

import com.sysu.moviepro.business.entity.Movie;

import java.util.List;

public interface MovieDAO {
	public int createMovie(Movie movie);
	public Movie updateMovie(Movie movie);
	public void deleteMovie(int id);
	public Movie getMovie(int id);
	public Movie getMovieByName(String name);
	public List<Movie> getAllMovies();
}