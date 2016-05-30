package com.sysu.moviepro.business.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sysu.moviepro.business.dao.SeatDAO;
import com.sysu.moviepro.business.entity.Seat;
import com.sysu.moviepro.business.service.SeatService;

@Service
@Transactional
public class SeatServiceImpl implements SeatService {
	
	public SeatServiceImpl() {
		System.out.println("SeatServiceImpl()");
	}
	
	@Autowired
	private SeatDAO seatDAO;
	
	@Override
	public int createSeat(Seat seat) {
		// TODO Auto-generated method stub
		return seatDAO.createSeat(seat);
	}

	@Override
	public Seat updateSeat(Seat seat) {
		// TODO Auto-generated method stub
		return seatDAO.updateSeat(seat);
	}

	@Override
	public void deleteSeat(int id) {
		// TODO Auto-generated method stub
		seatDAO.deleteSeat(id);
	}

	@Override
	public Seat getSeat(int id) {
		// TODO Auto-generated method stub
		return seatDAO.getSeat(id);
	}

	@Override
	public List<Seat> getAllSeats() {
		// TODO Auto-generated method stub
		return seatDAO.getAllSeats();
	}

	@Override
	public List<Seat> getAllSeatsByScreeningRoom(int sc_id) {
		// TODO Auto-generated method stub
		return seatDAO.getAllSeatsByScreeningRoom(sc_id);
	}

	@Override
	public void updateSeatStatus(int id, boolean status) {
		// TODO Auto-generated method stub
		seatDAO.updateSeatStatus(id, status);
	}

	@Override
	public Seat getSeatByRowAndCol(int rowNumber, int colNumber, int sc_id) {
		// TODO Auto-generated method stub
		return seatDAO.getSeatByRowAndCol(rowNumber, colNumber, sc_id);
	}
	
}
