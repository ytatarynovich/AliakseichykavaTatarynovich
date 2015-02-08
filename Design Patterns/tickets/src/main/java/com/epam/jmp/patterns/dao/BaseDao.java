package com.epam.jmp.patterns.dao;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import com.epam.jmp.patterns.model.Persistable;

public class BaseDao implements Dao {

	protected String getFileName() {
		return "temp.out";
	}

	public Persistable persist(Persistable entity) {
		entity.setId(new Date().getTime());

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(getFileName());
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(entity);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}

		System.out.println("Entity [" + entity.getId() + "] is saved");
		return entity;
	}

	public Persistable[] persist(Persistable[] entities) {
		for(Persistable entity : entities) {
			persist(entity);
		}
		return entities;
	}

}
