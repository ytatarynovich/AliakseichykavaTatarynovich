package com.epam.jmp.bank.dao;

import java.util.List;

import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

import com.epam.jmp.bank.model.CurrencyRate;

@NamedQueries({
@NamedQuery(
	name="CurrencyRate.findByName", 
	query="select e from CurrencyRate where e.currency = :currency"),
@NamedQuery(
	name = "CurrencyRate.update",
	query = "UPDATE CurrencyRate SET rate = :rate WHERE currency = :currency;")
})
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
				.setParameter("currency", name)
				.getSingleResult();
	}

	public void updateCurrency(String name, Double newRate) {

		em.createNamedQuery("CurrencyRate.update", CurrencyRate.class)
				.setParameter("currency", name)
				.setParameter("rate", newRate)
				.executeUpdate();
	}

}
