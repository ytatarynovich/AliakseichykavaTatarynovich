package com.epam.jmp.bank.services;

/**
 * @author Hanna_Aliakseichykava
 */
public interface CurrencyService {

	public void generateNewRates();

	public void refreshRates();
}
