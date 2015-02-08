package com.epam.jmp.patterns.model;

public class Entity implements Persistable {

	private long id;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
	}
}
