package com.sysu.moviepro.business.dto;

import com.sysu.moviepro.business.entity.Seat;

public class SeatDTO {
	private int id;
	private int rowNumber;
	private int colNumber;
	private boolean sold;
	private int price;
	private int screeningRoom_id;
	public SeatDTO() {
	}
	public SeatDTO(Seat seat) {
		id=seat.getId();
		rowNumber=seat.getRowNumber();
		colNumber=seat.getColNumber();
		sold=seat.isSold();
		price=seat.getPrice();
		screeningRoom_id=seat.getScreeningRoom().getId();
	}
	
	@Override
	public String toString() {
		return "SeatDTO [id=" + id + ", rowNumber=" + rowNumber + ", colNumber=" + colNumber + ", sold=" + sold
				+ ", price=" + price + ", screeningRoom_id=" + screeningRoom_id + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
	public int getColNumber() {
		return colNumber;
	}
	public void setColNumber(int colNumber) {
		this.colNumber = colNumber;
	}
	public boolean isSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getScreeningRoom_id() {
		return screeningRoom_id;
	}
	public void setScreeningRoom_id(int screeningRoom_id) {
		this.screeningRoom_id = screeningRoom_id;
	}
	
}
