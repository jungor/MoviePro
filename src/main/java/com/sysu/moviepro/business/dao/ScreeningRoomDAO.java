package com.sysu.moviepro.business.dao;

import java.util.List;

import com.sysu.moviepro.business.entity.ScreeningRoom;

public interface ScreeningRoomDAO {
	public int createScreeningRoom(ScreeningRoom screeningRoom);
	public ScreeningRoom updateScreenRoom(ScreeningRoom screeningRoom);
	public void deleteScreenRoom(int id);
	public ScreeningRoom getScreeningRoom(int id);
	public List<ScreeningRoom> getAllScreeningRooms();
}
