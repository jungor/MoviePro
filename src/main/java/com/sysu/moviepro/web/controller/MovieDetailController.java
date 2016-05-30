package com.sysu.moviepro.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sysu.moviepro.business.dto.ShowingDTO;
import com.sysu.moviepro.business.entity.Cinema;
import com.sysu.moviepro.business.entity.Movie;
import com.sysu.moviepro.business.entity.Showing;
import com.sysu.moviepro.business.service.CinemaService;
import com.sysu.moviepro.business.service.MovieService;
import com.sysu.moviepro.business.service.ShowingService;

@Controller
public class MovieDetailController {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieDetailController.class);
	
	@Autowired
	private MovieService movieService;
	@Autowired
	private CinemaService cinemaService;
	@Autowired
	private ShowingService showingService;
	
	// 根据电影名称返回电影详情以及排片信息
	@RequestMapping(value="/getMovie", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getMovie(String name) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Movie movie = movieService.getMovieByName(name);
		modelMap.put("movie", movie);
		List<Cinema> cinemas = cinemaService.getAllCinemas();
		for(Cinema cinema: cinemas) {
			List<Showing> showings = showingService.getShowingsByMovieAndCinema(movie.getId(), cinema.getId());
			List<ShowingDTO> showingDTOs = new ArrayList<ShowingDTO>();
			for (Showing showing: showings) {
				showingDTOs.add(new ShowingDTO(showing));
			}
			modelMap.put(cinema.getName(), showingDTOs);
		}
		return modelMap;
	}
}
