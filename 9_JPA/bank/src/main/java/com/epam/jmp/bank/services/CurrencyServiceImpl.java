package com.epam.jmp.bank.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.epam.jmp.bank.dao.CurrencyDao;
import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.model.CurrencyRate;
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
	}

	@Override
	public double exchangeCurrency(double amount, CurrencyRate currencyFrom, CurrencyRate currencyTo) {
		if(currencyFrom == null || currencyTo == null) {
			throw new RuntimeException("Exchange impossible from currency [" + currencyFrom + "] to currency [" + currencyTo + "]");
		}
		return amount * currencyFrom.getExchangeCoeff(currencyTo);
	}

	@Override
	public double exchangeCurrency(double amount, String currencyFrom, String currencyTo) {
		return exchangeCurrency(amount, currencyDao.findByName(currencyFrom), currencyDao.findByName(currencyTo));
	}

	@Override
	public void updateCurrency(String name, Double newRate) {
		currencyDao.updateCurrency(name, newRate);
	}

	private static final String NAME = "name";
	private static final String RATE = "rate";

	public String getAllCurrenciesAsJson() {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for(CurrencyRate currency : currencyDao.getAll()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put(NAME, currency.getCurrency().name());
			map.put(RATE, String.valueOf(currency.getRate()));
			list.add(map);
		}
		return new Gson().toJson(list);
	}
}
