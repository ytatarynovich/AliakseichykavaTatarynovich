package com.epam.jmp.bank.services;

import java.sql.SQLException;
import java.util.Map;

import com.epam.jmp.bank.dao.CurrencyDao;
import com.epam.jmp.bank.utils.CurrencyUtil;

/**
 * @author Hanna_Aliakseichykava
 */
public class CurrencyServiceImpl implements CurrencyService {

	private static final int MIN_RATE = 1;
	private static final int MAX_RATE = 15000;
	
	private CurrencyDao currencyDao;
	
	public CurrencyServiceImpl() {
		this.currencyDao = new CurrencyDao();
	}

	@Override
	public synchronized void generateNewRates() {
		Map<String, Double> newRates = CurrencyUtil.generateRandomRates(MIN_RATE, MAX_RATE);
		for(String name : newRates.keySet()) {
			try {
				currencyDao.updateCurrency(name, newRates.get(name));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public synchronized void refreshRates() {
		currencyDao.synchronizeCurrencies();
	}
}
