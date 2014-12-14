package com.epam.jmp.bank.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.epam.jmp.bank.dao.Dao;

import javax.persistence.Query;

/**
 * @author Hanna_Aliakseichykava
 */
public abstract class AbstractDao implements Dao {

	protected static final String ID = "id";

	protected static final Logger log = Logger.getLogger(AbstractDao.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public List getAllRows() {
		Query query = getEntityManager().createQuery("SELECT e FROM " + getTableName() + " e");
		return query.getResultList();
	}

	protected EntityManager getEntityManager() {
		return em;
	}

}
