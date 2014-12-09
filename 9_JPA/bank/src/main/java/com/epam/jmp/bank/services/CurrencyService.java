package com.epam.jmp.bank.services;

import com.epam.jmp.bank.model.CurrencyRate;

/**
 * @author Hanna_Aliakseichykava
 */
public interface CurrencyService {

	public void updateCurrency(String name, Double newRate);

	public String getAllCurrenciesAsJson();

	public double exchangeCurrency(double amount, CurrencyRate currencyFrom, CurrencyRate currencyTo);

	public double exchangeCurrency(double amount, String currencyFrom, String currencyTo);
}
