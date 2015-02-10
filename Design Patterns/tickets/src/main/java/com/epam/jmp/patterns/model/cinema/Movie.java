package com.epam.jmp.patterns.model.cinema;

import java.io.Serializable;

import com.epam.jmp.patterns.model.Entity;

public class Movie extends Entity implements Serializable {

	private String name;

	public Movie(String name) {
		super();
		validate(name);
		this.name = name;
	}

	private Movie(long id, String name) {
		this(name);
		setId(id);
	}

	@Override
	public String toString() {
		return "Movie: id: " + getId() + " - \"" + name + "\"";
	}

	@Override
	public Movie copy() {
		return new Movie(this.getId(), this.name);
	}

	@Override
	public void populate(Entity entity) {
		Movie movie = (Movie) entity;
		setId(movie.getId());
		this.name = movie.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		validate(name);
		this.name = name;
	}

	public static int MIN_NAME_LENGTH = 1;
	public static int MAX_NAME_LENGTH = 20;

	public void validate (String name) {
		if(name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new RuntimeException("New name length is not correct: " + name.length());
		}
	}
}
