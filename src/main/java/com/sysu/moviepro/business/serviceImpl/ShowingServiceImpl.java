package com.sysu.moviepro.business.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sysu.moviepro.business.dao.ShowingDAO;
import com.sysu.moviepro.business.entity.Showing;
import com.sysu.moviepro.business.service.ShowingService;

@Service
@Transactional
public class ShowingServiceImpl implements ShowingService {
	
	public ShowingServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("ShowingServiceImpl()");
	}
	
	@Autowired
	private ShowingDAO showingDAO;

	@Override
	public int createShowing(Showing showing) {
		// TODO Auto-generated method stub
		return showingDAO.createShowing(showing);
	}

	@Override
	public Showing updateShowing(Showing showing) {
		// TODO Auto-generated method stub
		return showingDAO.updateShowing(showing);
	}

	@Override
	public void deleteShowing(int id) {
		// TODO Auto-generated method stub
		showingDAO.deleteShowing(id);
	}

	@Override
	public Showing getShowing(int id) {
		// TODO Auto-generated method stub
		return showingDAO.getShowing(id);
	}

	@Override
	public List<Showing> getAllShowings() {
		// TODO Auto-generated method stub
		return showingDAO.getAllShowings();
	}

	@Override
	public List<Showing> getShowingsByMovieAndCinema(int movie_id, int cinema_id) {
		// TODO Auto-generated method stub
		return showingDAO.getShowingsByMovieAndCinema(movie_id, cinema_id);
	}
}
