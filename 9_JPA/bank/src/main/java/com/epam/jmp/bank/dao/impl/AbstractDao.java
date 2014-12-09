package com.epam.jmp.bank.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.jmp.bank.dao.Dao;

import javax.persistence.Query;

/**
 * @author Hanna_Aliakseichykava
 */
public abstract class AbstractDao implements Dao {

	protected static final String ID = "id";

	protected static final Logger log = Logger.getLogger(AbstractDao.class);

	@Autowired
	protected EntityManager em;

	synchronized protected Long generateId() {
		return new Long(getAllRows().size() + 1);
	}

	@Override
	public List getAllRows() {
		Query query = em.createQuery("SELECT e FROM " + getTableName() + " e");
		return query.getResultList();
	}

}
