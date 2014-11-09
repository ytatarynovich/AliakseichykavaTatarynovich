package com.epam.jmp.bank.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.epam.jmp.bank.dao.CurrencyDao;
import com.epam.jmp.bank.model.Currency;

/**
 * @author Hanna_Aliakseichykava
 */
@Component
public class CurrencyServiceImpl implements CurrencyService {

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

	public List<String> getAllCurrencies() {
		List<String> list = new ArrayList<String>();
		for(Currency currency : Currency.values()) {
			list.add(currency.name() + " - " + currency.getRate());
		}
		return list;
	}
}
