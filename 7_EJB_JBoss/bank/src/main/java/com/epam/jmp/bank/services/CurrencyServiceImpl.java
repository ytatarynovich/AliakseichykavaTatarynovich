package com.epam.jmp.bank.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.epam.jmp.bank.dao.CurrencyDao;
import com.epam.jmp.bank.model.Currency;
import com.google.gson.Gson;

/**
 * @author Hanna_Aliakseichykava
 */
@Stateless
public class CurrencyServiceImpl implements CurrencyService {

	private static final long serialVersionUID = 4L;
	private CurrencyDao currencyDao;

	public CurrencyServiceImpl() {
		this.currencyDao = new CurrencyDao();
		refreshRates();
	}

	@Override
	public synchronized void refreshRates() {
		currencyDao.synchronizeCurrencies();
	}

	@Override
	public void updateCurrency(Currency currency) {
		try {
			currencyDao.updateCurrency(currency.name(), currency.getRate());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private static final String NAME = "name";
	private static final String RATE = "rate";

	public String getAllCurrenciesAsJson() {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for(Currency currency : Currency.values()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put(NAME, currency.getName());
			map.put(RATE, String.valueOf(currency.getRate()));
			list.add(map);
		}
		return new Gson().toJson(list);
	}
}
