package com.sysu.moviepro.business.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="screeningroom")
public class ScreeningRoom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private int number;
	
	@Column
	private int rowNum;
	
	@Column
	private int colNum;
	
	@OneToMany(targetEntity=Showing.class, mappedBy="screeningRoom")
	private Set<Showing> showing;
	
	@OneToMany(targetEntity=Seat.class, mappedBy="screeningRoom")
	private Set<Seat> seats;
	
	@ManyToOne(targetEntity=Cinema.class,cascade=CascadeType.ALL)
	@JoinColumn(name="cinema_id")
	private Cinema cinema;

	public ScreeningRoom() {}
	
	@Override
	public String toString() {
		return "ScreeningRoom [id=" + id + ", number=" + number + ", rowNum=" + rowNum + ", colNum=" + colNum
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

	public Set<Showing> getShowing() {
		return showing;
	}

	public void setShowing(Set<Showing> showing) {
		this.showing = showing;
	}

	public Set<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cinema == null) ? 0 : cinema.hashCode());
		result = prime * result + colNum;
		result = prime * result + number;
		result = prime * result + rowNum;
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
		ScreeningRoom other = (ScreeningRoom) obj;
		if (cinema == null) {
			if (other.cinema != null)
				return false;
		} else if (!cinema.equals(other.cinema))
			return false;
		if (colNum != other.colNum)
			return false;
		if (number != other.number)
			return false;
		if (rowNum != other.rowNum)
			return false;
		return true;
	}
}
