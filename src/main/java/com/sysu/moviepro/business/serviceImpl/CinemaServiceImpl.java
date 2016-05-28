package com.sysu.moviepro.business.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sysu.moviepro.business.entity.Cinema;
import com.sysu.moviepro.business.service.CinemaService;
import com.sysu.moviepro.business.dao.CinemaDAO;

@Service
@Transactional
public class CinemaServiceImpl implements CinemaService {

	public CinemaServiceImpl() {
		System.out.println("CinemaServiceImpl()");
	}

	@Autowired
	private CinemaDAO CinemaDAO;

	@Override
	public int createCinema(Cinema Cinema) {
		// TODO Auto-generated method stub
		return CinemaDAO.createCinema(Cinema);
	}

	@Override
	public Cinema updateCinema(Cinema Cinema) {
		// TODO Auto-generated method stub
		return CinemaDAO.updateCinema(Cinema);
	}

	@Override
	public void deleteCinema(int id) {
		// TODO Auto-generated method stub
		CinemaDAO.deleteCinema(id);
	}

	@Override
	public Cinema getCinema(int id) {
		// TODO Auto-generated method stub
		return CinemaDAO.getCinema(id);
	}
	
	@Override
	public Cinema getCinemaByName(String name) {
		return CinemaDAO.getCinemaByName(name);
	}

	@Override
	public List<Cinema> getAllCinemas() {
		// TODO Auto-generated method stub
		return CinemaDAO.getAllCinemas();
	}
}
