package com.sysu.moviepro.business.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="seat")
public class Seat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private int rowNumber;
	
	@Column
	private int colNumber;
	
	@Column
	private boolean sold;
	
	@Column
	private int price;
	
	@ManyToOne(targetEntity=ScreeningRoom.class, cascade=CascadeType.ALL)
	@JoinColumn(name="screeingRoom_id")
	private ScreeningRoom screeningRoom;
	
	@OneToOne(targetEntity=Ticket.class, mappedBy="seat")
	private Ticket ticket;
	
	public Seat() {}

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

	public ScreeningRoom getScreeningRoom() {
		return screeningRoom;
	}

	public void setScreeningRoom(ScreeningRoom screeningRoom) {
		this.screeningRoom = screeningRoom;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", rowNumber=" + rowNumber + ", colNumber=" + colNumber + ", sold=" + sold
				+ ", price=" + price + ", screeningRoom=" + screeningRoom + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + colNumber;
		result = prime * result + price;
		result = prime * result + rowNumber;
		result = prime * result + ((screeningRoom == null) ? 0 : screeningRoom.hashCode());
		result = prime * result + (sold ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		if (colNumber != other.colNumber)
			return false;
		if (price != other.price)
			return false;
		if (rowNumber != other.rowNumber)
			return false;
		if (screeningRoom == null) {
			if (other.screeningRoom != null)
				return false;
		} else if (!screeningRoom.equals(other.screeningRoom))
			return false;
		if (sold != other.sold)
			return false;
		return true;
	}
}
