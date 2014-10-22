package com.epam.jmp.concurrency.utils;

import org.apache.log4j.Logger;

import com.epam.jmp.concurrency.model.Currency;

/**
 * @author Hanna_Aliakseichykava
 */
public class CurrencyUtil {
	
	private static final Logger log = Logger.getLogger(CurrencyUtil.class);

	public static double exchangeCurrency(double amount, Currency currencyFrom, Currency currencyTo) {
		return amount * currencyFrom.getExchangeRate(currencyTo);
	}

	public static void printAllCurrencies() {
		log.info("**** Currency ****");
		for(Currency currency : Currency.values()) {
			log.info(currency);
		}
		log.info("******************");
	}
}
