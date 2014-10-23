package com.epam.jmp.concurrency.model;

import com.epam.jmp.concurrency.exceptions.CurrencyNotFoundException;

/**
 * @author Hanna_Aliakseichykava
 */
public enum Currency {

	BY	(1, 1),
	USD	(2, 10000),
	EU	(3, 13000);

	private int code;
	private double rate;

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
			throw new RuntimeException("Rate for BY can not be changed (base).");
		}
		this.rate = newRate;
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

}
