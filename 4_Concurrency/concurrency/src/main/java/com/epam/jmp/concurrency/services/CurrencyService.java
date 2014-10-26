package com.epam.jmp.concurrency.services;

/**
 * @author Hanna_Aliakseichykava
 */
public interface CurrencyService {

	public void generateNewRates();

	public void refreshRates();
}
