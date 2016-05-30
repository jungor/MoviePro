package com.sysu.moviepro.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sysu.moviepro.business.entity.User;
import com.sysu.moviepro.business.service.MovieService;
import com.sysu.moviepro.business.service.UserService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(HttpSession session) {	
		User user = (User)session.getAttribute("user");
		if (user != null) {
			User result = userService.getUser(user.getId());
			logger.info(result.toString());
		} else {
			logger.info("当前用户未登录");
		}
		return "home";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.removeAttribute("user");
		Cookie cookie = new Cookie("username", null);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		return "redirect:home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	@RequestMapping(value="/getAllMovies", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAllMovieName() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<String> movies = movieService.getAllMovieNames();
		modelMap.put("movies", movies);
		return modelMap;
	}
}
