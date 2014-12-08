package com.epam.jmp.bank.services;

import java.io.Serializable;

import javax.ejb.Local;

import com.epam.jmp.bank.model.CurrencyRate;

/**
 * @author Hanna_Aliakseichykava
 */
@Local
public interface CurrencyService extends Serializable {

	public void updateCurrency(String name, Double newRate);

	public String getAllCurrenciesAsJson();

	public double exchangeCurrency(double amount, CurrencyRate currencyFrom, CurrencyRate currencyTo);

	public double exchangeCurrency(double amount, String currencyFrom, String currencyTo);
}
