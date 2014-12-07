package com.epam.jmp.bank.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import javax.persistence.Query;

/**
 * @author Hanna_Aliakseichykava
 */
public abstract class AbstractDao implements ConfigConst, Serializable {

	private static final long serialVersionUID = 1L;

	protected static final String ID = "id";

	protected static final Logger log = Logger.getLogger(AbstractDao.class);
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.epam.jmp.bank");
	protected EntityManager em = emf.createEntityManager();

	public AbstractDao() {
	}

	protected abstract String getTableName();

	synchronized protected Long generateId() {
		return new Long(getAllRows().size() + 1);
	}

	protected List getAllRows() {
		Query query = em.createQuery("SELECT e FROM " + getTableName() + " e");
		return query.getResultList();
	}

}
