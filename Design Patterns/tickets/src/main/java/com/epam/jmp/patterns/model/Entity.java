package com.epam.jmp.patterns.model;

public abstract class Entity {

	private long id;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
	}

	public abstract Entity copy();

	public abstract void populate(Entity entity);
}
