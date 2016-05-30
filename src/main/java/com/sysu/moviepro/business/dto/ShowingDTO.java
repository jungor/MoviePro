package com.sysu.moviepro.business.dto;

import com.sysu.moviepro.business.entity.Showing;

public class ShowingDTO {
	private int id;
	private String date;
	private String time;
	private int screeningRoom_id;
	
	public ShowingDTO() {
	}
	
	public ShowingDTO(Showing showing) {
		id=showing.getId();
		date=showing.getDate();
		time=showing.getTime();
		screeningRoom_id=showing.getScreeningRoom().getId();
	}

	@Override
	public String toString() {
		return "ShowingDTO [id=" + id + ", date=" + date + ", time=" + time + ", screeningRoom_id=" + screeningRoom_id
				+ "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getScreeningRoom_id() {
		return screeningRoom_id;
	}
	public void setScreeningRoom_id(int screeningRoom_id) {
		this.screeningRoom_id = screeningRoom_id;
	}
}
