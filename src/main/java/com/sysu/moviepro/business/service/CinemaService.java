package com.sysu.moviepro.business.service;

import java.util.List;

import com.sysu.moviepro.business.entity.Cinema;

public interface CinemaService {
	public int createCinema(Cinema cinema);
	public Cinema updateCinema(Cinema cinema);
	public void deleteCinema(int id);
	public Cinema getCinema(int id);
	public Cinema getCinemaByName(String name);
	public List<Cinema> getAllCinemas(); 
}
