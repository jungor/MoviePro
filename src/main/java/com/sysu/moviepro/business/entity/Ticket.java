package com.sysu.moviepro.business.entity;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column
	private int price;
	
	@Column
	private Calendar soldDate;

	public Ticket() {}
	
	public Ticket(int price, Calendar soldDate) {
		super();
		this.price = price;
		this.soldDate = soldDate;
	}

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

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", price=" + price + ", soldDate=" + soldDate + "]";
	}
}
