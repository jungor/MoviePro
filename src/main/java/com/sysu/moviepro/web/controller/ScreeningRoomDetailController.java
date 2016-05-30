package com.sysu.moviepro.web.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sysu.moviepro.business.dto.ScreeningRoomDTO;
import com.sysu.moviepro.business.entity.ScreeningRoom;
import com.sysu.moviepro.business.entity.Seat;
import com.sysu.moviepro.business.entity.Ticket;
import com.sysu.moviepro.business.entity.User;
import com.sysu.moviepro.business.service.OrderService;
import com.sysu.moviepro.business.service.ScreeningRoomService;
import com.sysu.moviepro.business.service.SeatService;
import com.sysu.moviepro.business.service.TicketService;

@Controller
public class ScreeningRoomDetailController {
	
	private static final Logger logger = LoggerFactory.getLogger(ScreeningRoomDetailController.class);
	
	@Autowired
	private ScreeningRoomService screeningRoomService;
	@Autowired
	private SeatService seatService;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private OrderService orderService;
	
	// 根据放映室id获取放映室信息
	@RequestMapping(value="/getScreeningRoom", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getScreeningRoom(Integer screeningRoom_id) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		ScreeningRoom screeningRoom = screeningRoomService.getScreeningRoom(screeningRoom_id);
		ScreeningRoomDTO screeningRoomDTO = new ScreeningRoomDTO(screeningRoom);
		modelMap.put("screeningRoom", screeningRoomDTO);
		return modelMap;
	}
	
	// 根据放映室id获取座位信息
	@RequestMapping(value="/getSeats",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAllSeats(Integer screeningRoom_id) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Seat> seats = seatService.getAllSeatsByScreeningRoom(screeningRoom_id);
		//List<SeatDTO> seatDTOs = new ArrayList<SeatDTO>(); 
		StringBuffer sb = new StringBuffer();
		for (Seat seat: seats) {
			//SeatDTO seatDTO = new SeatDTO(seat);
			//seatDTOs.add(seatDTO);
			if (seat.isSold())
				sb.append(seat.getRowNumber()+","+seat.getColNumber()+";");
		}
		modelMap.put("seats", sb);
		return modelMap;
	}
	
	// 下订单
	@RequestMapping(value="/makeOrder", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> makeOrder(String seats, Integer screeningRoom_id, HttpSession session) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		User user = (User) session.getAttribute("user");
		// 用户已登录
		if (user != null) {
			modelMap.put("code", 1);
			String[] positions = seats.split(";");
			Set<Ticket> tickets = new HashSet<Ticket>();
			for (String position : positions) {
				int row = Integer.valueOf(position.split(",")[0]);
				int col = Integer.valueOf(position.split(",")[1]);
				Seat seat = seatService.getSeatByRowAndCol(row, col, screeningRoom_id);
				Ticket ticket = ticketService.createTicketBySeat(seat);
				seatService.updateSeatStatus(seat.getId(), true);
				tickets.add(ticket);
			}
			orderService.createOrderByTickets(user, tickets);
		} else {
			modelMap.put("code", 0);
		}
		return modelMap;
	}
}
