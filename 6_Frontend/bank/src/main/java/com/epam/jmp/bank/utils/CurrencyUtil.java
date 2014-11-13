package com.epam.jmp.bank.utils;

import com.epam.jmp.bank.model.Currency;

/**
 * @author Hanna_Aliakseichykava
 */
public class CurrencyUtil {

	public static Currency findCurrencyByCode(int code) {
		return Currency.findByCode(code);
	}

	public static double exchangeCurrency(double amount, Currency currencyFrom, Currency currencyTo) {
		if(currencyFrom == null || currencyTo == null) {
			throw new RuntimeException("Exchange impossible from currency [" + currencyFrom + "] to currency [" + currencyTo + "]");
		}
		return amount * currencyFrom.getExchangeCoeff(currencyTo);
	}

	public static double exchangeCurrency(double amount, String currencyFrom, String currencyTo) {
		return exchangeCurrency(amount, Currency.findByName(currencyFrom), Currency.findByName(currencyTo));
	}
}
