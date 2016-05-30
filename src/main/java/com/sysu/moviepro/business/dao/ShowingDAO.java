package com.sysu.moviepro.business.dao;

import java.util.List;

import com.sysu.moviepro.business.entity.Showing;

public interface ShowingDAO {
	public int createShowing(Showing showing);
	public Showing updateShowing(Showing showing);
	public void deleteShowing(int id);
	public Showing getShowing(int id);
	public List<Showing> getAllShowings();
	
	public List<Showing> getShowingsByMovieAndCinema(int movie_id, int cinema_id); 
}
