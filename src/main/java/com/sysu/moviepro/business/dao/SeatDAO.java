package com.sysu.moviepro.business.dao;

import java.util.List;

import com.sysu.moviepro.business.entity.Seat;

public interface SeatDAO {
	public int createSeat(Seat seat);
	public Seat updateSeat(Seat seat);
	public void deleteSeat(int id);
	public Seat getSeat(int id);
	public List<Seat> getAllSeats();
	
	public List<Seat> getAllSeatsByScreeningRoom(int sc_id);
	public Seat getSeatByRowAndCol(int rowNumber, int colNumber, int sc_id);
	public void updateSeatStatus(int id, boolean status);
}
