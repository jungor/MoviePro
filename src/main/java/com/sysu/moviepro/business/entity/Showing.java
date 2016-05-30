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
@Table(name="showing")
public class Showing {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String date;
	
	@Column
	private String time;

	@ManyToOne(targetEntity=Cinema.class,cascade=CascadeType.ALL)
	@JoinColumn(name="cinema_id")
	private Cinema cinema;
	
	@OneToOne(targetEntity=Movie.class)
	@JoinColumn(name="movie_id", unique=true)
	private Movie movie;
	
	@ManyToOne(targetEntity=ScreeningRoom.class,cascade=CascadeType.ALL)
	@JoinColumn(name="screeningroom_id")
	private ScreeningRoom screeningRoom;

	public Showing() {}

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
	
	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public ScreeningRoom getScreeningRoom() {
		return screeningRoom;
	}

	public void setScreeningRoom(ScreeningRoom screeningRoom) {
		this.screeningRoom = screeningRoom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cinema == null) ? 0 : cinema.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((screeningRoom == null) ? 0 : screeningRoom.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		Showing other = (Showing) obj;
		if (cinema == null) {
			if (other.cinema != null)
				return false;
		} else if (!cinema.equals(other.cinema))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (screeningRoom == null) {
			if (other.screeningRoom != null)
				return false;
		} else if (!screeningRoom.equals(other.screeningRoom))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
}
