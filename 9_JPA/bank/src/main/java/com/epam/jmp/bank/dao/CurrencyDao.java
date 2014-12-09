package com.epam.jmp.bank.dao;

import java.util.List;

import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.model.CurrencyRate;

public class CurrencyDao extends AbstractDao {

	public CurrencyDao() {
		super();
	}

	@Override
	protected String getTableName() {
		return "CurrencyRate";
	}

	public List<CurrencyRate> getAll() {
		return (List<CurrencyRate>) getAllRows();
	}

	public CurrencyRate findByName(String name) {
		return em.createNamedQuery("CurrencyRate.findByName", CurrencyRate.class)
				.setParameter("currency", Currency.findByName(name))
				.getSingleResult();
	}

	public void updateCurrency(String name, Double newRate) {

		CurrencyRate cRate = findByName(name);

		em.getTransaction().begin();
		cRate.setRate(newRate);
		em.getTransaction().commit();
	}

}
