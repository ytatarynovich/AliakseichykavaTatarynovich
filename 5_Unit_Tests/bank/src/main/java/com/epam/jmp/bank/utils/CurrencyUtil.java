package com.epam.jmp.bank.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.utils.RandomUtils;

/**
 * @author Hanna_Aliakseichykava
 */
public class CurrencyUtil {

	private static final Logger log = Logger.getLogger(CurrencyUtil.class);

	public static Currency findCurrencyByCode(int code) {
		return Currency.findByCode(code);
	}

	public static double exchangeCurrency(double amount, Currency currencyFrom, Currency currencyTo) {
		if(currencyFrom == null || currencyTo == null) {
			throw new RuntimeException("Exchange impossible from currency [" + currencyFrom + "] to currency [" + currencyTo + "]");
		}
		return amount * currencyFrom.getExchangeCoeff(currencyTo);
	}

	public static void printAllCurrencies() {
		log.info("***************************************************");
		log.info("Code | Currency | Exchange Rate against BY currency");
		for(Currency currency : Currency.values()) {
			log.info(String.format("%-4s | %-8s | %-2s", currency.getCode(), currency, currency.getRate()));
		}
		log.info("***************************************************");
	}

	public static Map<String, Double> generateRandomRates(int minRate, int maxRate) {
		Map<String, Double> currencies = new HashMap<String, Double>();
		for(Currency currency : Currency.values()) {
			if(currency != Currency.BY) {
				currencies.put(currency.name(), RandomUtils.getRandomDouble(minRate, maxRate));
			}
		}
		return currencies;
	}
}
