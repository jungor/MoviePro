package com.sysu.moviepro.business.dao;

import com.sysu.moviepro.business.entity.Cinema;

import java.util.List;

public interface CinemaDAO {
	public int createCinema(Cinema cinema);
	public Cinema updateCinema(Cinema cinema);
	public void deleteCinema(int id);
	public Cinema getCinema(int id);
	public Cinema getCinemaByName(String name);
	public List<Cinema> getAllCinemas();
}
