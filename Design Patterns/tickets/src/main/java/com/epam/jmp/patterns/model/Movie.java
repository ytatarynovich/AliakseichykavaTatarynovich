package com.epam.jmp.patterns.model;

import java.io.Serializable;

public class Movie extends Entity implements Serializable {

	private String name;

	public Movie(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Movie \"" + name + "\"";
	}

}
