package com.sysu.moviepro.business.dto;

import com.sysu.moviepro.business.entity.Cinema;
import com.sysu.moviepro.business.entity.ScreeningRoom;

public class ScreeningRoomDTO {
	private int id;
	private int number;
	private int rowNum;
	private int colNum;
	private Cinema cinema;
	public ScreeningRoomDTO() {
	}
	
	public ScreeningRoomDTO(ScreeningRoom screeningRoom) {
		id = screeningRoom.getId();
		number = screeningRoom.getNumber();
		rowNum = screeningRoom.getRowNum();
		colNum = screeningRoom.getColNum();
		cinema = screeningRoom.getCinema();
	}
	

	@Override
	public String toString() {
		return "ScreeningRoomDTO [id=" + id + ", number=" + number + ", rowNum=" + rowNum + ", colNum=" + colNum
				+ ", cinema=" + cinema + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getColNum() {
		return colNum;
	}

	public void setColNum(int colNum) {
		this.colNum = colNum;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
}
