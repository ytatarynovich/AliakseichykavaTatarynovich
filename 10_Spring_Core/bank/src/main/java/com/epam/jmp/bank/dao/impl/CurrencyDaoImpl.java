package com.epam.jmp.bank.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jmp.bank.dao.CurrencyDao;
import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.model.CurrencyRate;

@Repository
public class CurrencyDaoImpl extends AbstractDao implements  CurrencyDao {

	@Override
	public String getTableName() {
		return "CurrencyRate";
	}

	@Override
	public List<CurrencyRate> getAll() {
		return (List<CurrencyRate>) getAllRows();
	}

	@Override
	public CurrencyRate findByName(String name) {
		return getEntityManager().createNamedQuery("CurrencyRate.findByName", CurrencyRate.class)
				.setParameter("currency", Currency.findByName(name))
				.getSingleResult();
	}

	@Override
	@Transactional
	public void update(String name, Double newRate) {

		CurrencyRate cRate = findByName(name);
		cRate.setRate(newRate);
	}

}
