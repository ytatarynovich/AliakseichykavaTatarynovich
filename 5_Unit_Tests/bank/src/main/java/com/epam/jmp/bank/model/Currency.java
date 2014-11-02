package com.epam.jmp.bank.model;

import org.apache.log4j.Logger;

import com.epam.jmp.bank.exceptions.CurrencyNotFoundException;
import com.epam.jmp.utils.RandomUtils;

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

	public static Currency findByName(String name) {
		name = name != null ? name.toUpperCase() : name;
		for(Currency currency : values()) {
			if(currency.name().toUpperCase().equals(name)) {
				return currency;
			}
		}
		throw new CurrencyNotFoundException(name);
	}

	public static void setDefaultValues() {
		for(Currency currency : values()) {
			if(currency != BY) {
				currency.setRate(1);
			}
		}
	}

}
