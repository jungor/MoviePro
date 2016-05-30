package com.sysu.moviepro.business.service;

import java.util.List;

import com.sysu.moviepro.business.entity.ScreeningRoom;

public interface ScreeningRoomService {
	public int createScreeningRoom(ScreeningRoom screeningRoom);
	public ScreeningRoom updateScreeningRoom(ScreeningRoom screeningRoom);
	public void deleteScreeningRoom(int id);
	public ScreeningRoom getScreeningRoom(int id);
	public List<ScreeningRoom> getAllScreeningRooms();
}
