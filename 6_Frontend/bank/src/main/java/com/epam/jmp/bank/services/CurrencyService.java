package com.epam.jmp.bank.services;

import java.util.List;

import com.epam.jmp.bank.model.Currency;

/**
 * @author Hanna_Aliakseichykava
 */
public interface CurrencyService {

	public void refreshRates();

	public void updateCurrency(Currency currency);

	public List<String> getAllCurrencies();
}
