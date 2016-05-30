package com.sysu.moviepro.business.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sysu.moviepro.business.dao.ScreeningRoomDAO;
import com.sysu.moviepro.business.entity.ScreeningRoom;
import com.sysu.moviepro.business.service.ScreeningRoomService;

@Service
@Transactional
public class ScreeningRoomServiceImpl implements ScreeningRoomService {
	
	public ScreeningRoomServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("ScreeningRoomSreviceImpl()");
	}
	
	@Autowired
	private ScreeningRoomDAO screeningRoomDAO;

	@Override
	public int createScreeningRoom(ScreeningRoom screeningRoom) {
		// TODO Auto-generated method stub
		return screeningRoomDAO.createScreeningRoom(screeningRoom);
	}

	@Override
	public ScreeningRoom updateScreeningRoom(ScreeningRoom screeningRoom) {
		// TODO Auto-generated method stub
		return screeningRoomDAO.updateScreenRoom(screeningRoom);
	}

	@Override
	public void deleteScreeningRoom(int id) {
		// TODO Auto-generated method stub
		screeningRoomDAO.deleteScreenRoom(id);
	}

	@Override
	public ScreeningRoom getScreeningRoom(int id) {
		// TODO Auto-generated method stub
		return screeningRoomDAO.getScreeningRoom(id);
	}

	@Override
	public List<ScreeningRoom> getAllScreeningRooms() {
		// TODO Auto-generated method stub
		return screeningRoomDAO.getAllScreeningRooms();
	}

}
