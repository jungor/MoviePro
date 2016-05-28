package com.sysu.moviepro.business.entity;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String director;
	
	@Column
	private String mainActor;
	
	@Column
	private int type;
	
	@Column
	private Calendar duration;
	
	@Column
	private Calendar releaseTime;
	
	@Column
	private String description;
	
	public Movie() {}

	public Movie(String name, String director, String mainActor, int type, Calendar duration, Calendar releaseTime,
			String description) {
		super();
		this.name = name;
		this.director = director;
		this.mainActor = mainActor;
		this.type = type;
		this.duration = duration;
		this.releaseTime = releaseTime;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getMainActor() {
		return mainActor;
	}

	public void setMainActor(String mainActor) {
		this.mainActor = mainActor;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Calendar getDuration() {
		return duration;
	}

	public void setDuration(Calendar duration) {
		this.duration = duration;
	}

	public Calendar getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Calendar releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", director=" + director + ", mainActor=" + mainActor + ", type="
				+ type + ", duration=" + duration + ", releaseTime=" + releaseTime + ", description=" + description + "]";
	}
}
