package com.sysu.moviepro.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sysu.moviepro.business.entity.Cinema;
import com.sysu.moviepro.business.entity.Movie;
import com.sysu.moviepro.business.entity.ScreeningRoom;
import com.sysu.moviepro.business.entity.Seat;
import com.sysu.moviepro.business.entity.Showing;
import com.sysu.moviepro.business.service.CinemaService;
import com.sysu.moviepro.business.service.MovieService;
import com.sysu.moviepro.business.service.ScreeningRoomService;
import com.sysu.moviepro.business.service.SeatService;
import com.sysu.moviepro.business.service.ShowingService;

@Controller
public class AddInformationController {
	
	private static final Logger logger = LoggerFactory.getLogger(AddInformationController.class);
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value="/movie/add", method=RequestMethod.POST)
	@ResponseBody
	public void addMovie(@ModelAttribute Movie movie) {
		int id = movieService.createMovie(movie);
		logger.info(movie.toString());
	}
	
	@Autowired
	private CinemaService cinemaService;
	
	@RequestMapping(value="/cinema/add", method=RequestMethod.POST)
	@ResponseBody
	public void addMovie(@ModelAttribute Cinema cinema) {
		int id = cinemaService.createCinema(cinema);
		logger.info(cinema.toString());
	}
	
	@Autowired
	private ShowingService showingService;
	
	@RequestMapping(value="/showing/add", method=RequestMethod.POST)
	@ResponseBody
	public void addShowing(String date, String time, Integer movie_id, Integer cinema_id, Integer screeningRoom_id) {
		Movie movie = movieService.getMovie(movie_id);
		Cinema cinema = cinemaService.getCinema(cinema_id);
		ScreeningRoom screeningRoom = screeningRoomService.getScreeningRoom(screeningRoom_id);
		Showing showing = new Showing();
		showing.setDate(date);
		showing.setTime(time);
		showing.setMovie(movie);
		showing.setCinema(cinema);
		showing.setScreeningRoom(screeningRoom);
		showingService.createShowing(showing);
	}
	
	@Autowired
	private ScreeningRoomService screeningRoomService;
	
	@RequestMapping(value="/screeningroom/add", method=RequestMethod.POST)
	@ResponseBody
	public void addScreeningRoom(Integer number, Integer row, Integer col, Integer cinema_id) {
		Cinema cinema = cinemaService.getCinema(cinema_id);
		ScreeningRoom screeningRoom = new ScreeningRoom();
		screeningRoom.setNumber(number);
		screeningRoom.setRowNum(row);
		screeningRoom.setColNum(col);
		screeningRoom.setCinema(cinema);
		screeningRoomService.createScreeningRoom(screeningRoom);
	}
	
	@Autowired
	private SeatService seatService;
	
	@RequestMapping(value="/seat/add", method=RequestMethod.POST)
	@ResponseBody
	public void addSeatsInScreeningRoom(Integer screeningRoom_id, Integer price) {
		ScreeningRoom screeningRoom = screeningRoomService.getScreeningRoom(screeningRoom_id);
		for (int i = 1; i <= screeningRoom.getRowNum(); i++) {
			for (int j = 1; j <= screeningRoom.getColNum(); j++) {
				Seat seat = new Seat();
				seat.setRowNumber(i);
				seat.setColNumber(j);
				seat.setPrice(price);
				seat.setSold(false);
				seat.setScreeningRoom(screeningRoom);
				seatService.createSeat(seat);
			}
		}
	}
}