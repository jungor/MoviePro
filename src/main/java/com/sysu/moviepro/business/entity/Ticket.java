package com.sysu.moviepro.business.entity;


import java.util.Calendar;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column
	private int price;
	
	@Column
	@Temporal(value=TemporalType.TIMESTAMP)
	private Calendar soldDate;
	
	@OneToOne(targetEntity=Seat.class)
	@JoinColumn(name="seat_id", unique=true)
	private Seat seat;
	
	@ManyToOne(targetEntity=Order.class,cascade=CascadeType.ALL)
	@JoinColumn(name="order_id")
	private Order order;

	public Ticket() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Calendar getSoldDate() {
		return soldDate;
	}

	public void setSoldDate(Calendar soldDate) {
		this.soldDate = soldDate;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", price=" + price + ", soldDate=" + soldDate + ", seat=" + seat + ", order="
				+ order + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + price;
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		result = prime * result + ((soldDate == null) ? 0 : soldDate.hashCode());
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
		Ticket other = (Ticket) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (price != other.price)
			return false;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
			return false;
		if (soldDate == null) {
			if (other.soldDate != null)
				return false;
		} else if (!soldDate.equals(other.soldDate))
			return false;
		return true;
	}
}
