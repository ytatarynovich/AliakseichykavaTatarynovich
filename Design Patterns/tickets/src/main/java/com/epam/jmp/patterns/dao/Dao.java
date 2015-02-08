package com.epam.jmp.patterns.dao;

import com.epam.jmp.patterns.model.Persistable;

public interface Dao {

	public Persistable persist(Persistable entity);
	public Persistable[] persist(Persistable[] entities);
}
