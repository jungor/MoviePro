package com.sysu.moviepro.business.service;

import java.util.List;

import com.sysu.moviepro.business.entity.Movie;

public interface MovieService {
	public int createMovie(Movie Movie);
	public Movie updateMovie(Movie Movie);
	public void deleteMovie(int id);
	public Movie getMovie(int id);
	public Movie getMovieByName(String name);
	public List<Movie> getAllMovies(); 
	public List<String> getAllMovieNames(); 
}
