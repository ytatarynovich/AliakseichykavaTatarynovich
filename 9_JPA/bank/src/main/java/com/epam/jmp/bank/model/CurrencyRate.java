package com.epam.jmp.bank.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import org.apache.log4j.Logger;

import com.google.common.annotations.VisibleForTesting;

@NamedQueries({
@NamedQuery(
	name="CurrencyRate.findByName", 
	query="select e from CurrencyRate e where e.currency = :currency")
})
@Entity
public class CurrencyRate {

	@Transient
	private static final Logger log = Logger.getLogger(CurrencyRate.class);

	@Id
	private Long id;
	private double rate;

	@Enumerated(EnumType.STRING)
	private Currency currency;

	public CurrencyRate() {}

	@VisibleForTesting
	public CurrencyRate(double rate, Currency currency) {
		super();
		this.rate = rate;
		this.currency = currency;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double newRate) {
		if(newRate < 0) {
			throw new RuntimeException("Exchange rate should be positive number instead of [" + newRate + "].");
		} else {
			this.rate = newRate;
			log.info("Exchange rate is updated: " + currency + " - " + rate + " (" + this + ")");
		}
	}

	public double getExchangeCoeff(CurrencyRate anotherCurrency) {
		return rate / anotherCurrency.getRate();
	}
}
