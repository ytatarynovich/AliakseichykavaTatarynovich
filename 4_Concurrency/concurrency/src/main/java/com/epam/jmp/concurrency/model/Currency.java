package com.epam.jmp.concurrency.model;

import org.apache.log4j.Logger;
import com.epam.jmp.concurrency.exceptions.CurrencyNotFoundException;

/**
 * @author Hanna_Aliakseichykava
 */
public enum Currency {

	BY	(1, 1),
	USD	(2, 1),
	EU	(3, 1);

	private int code;
	private double rate;
	
	private static final Logger log = Logger.getLogger(Currency.class);

	Currency(int code, double rate) {
		this.code = code;
		this.rate = rate;
	}

	public int getCode() {
		return code;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double newRate) {
		if(this == BY) {
			log.warn("Rate for BY can not be changed (base).");
			return;
		} else if(newRate < 0) {
			throw new RuntimeException("Exchange rate should be positive number instead of [" + newRate + "].");
		} else {
			this.rate = newRate;
			log.info("Exchange rate is updated: " + code + " - " + rate + " (" + this + ")");
		}
	}

	public double getExchangeCoeff(Currency anotherCurrency) {
		return rate / anotherCurrency.getRate();
	}

	public static Currency findByCode(int code) {
		for(Currency currency : values()) {
			if(currency.getCode() == code) {
				return currency;
			}
		}
		throw new CurrencyNotFoundException(code);
	}

	public static final String DELIMETER = ":";

	/**
	 * Format: code:rate
	 * see CurrencyUtil.generateRandomRates
	 */
	public static Currency updateFromString(String str) {
		int delimPos = str.indexOf(DELIMETER);
		if(delimPos <= 0) {
			throw new RuntimeException("String [" + str + "] can not be parsed to Currency");
		}

		String _codeStr = str.substring(0, delimPos).trim();
		int _code = Integer.valueOf(_codeStr);
		String _rateStr = str.substring(delimPos + 1).trim();
		double _rate = Double.valueOf(_rateStr);

		Currency _currency =  findByCode(_code);
		_currency.setRate(_rate);

		return _currency;
	}

}
