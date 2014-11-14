package com.epam.jmp.bank.services;

import java.io.Serializable;

import javax.ejb.Local;

import com.epam.jmp.bank.model.Currency;

/**
 * @author Hanna_Aliakseichykava
 */
@Local
public interface CurrencyService extends Serializable {

	public void refreshRates();

	public void updateCurrency(Currency currency);

	public String getAllCurrenciesAsJson();
}
