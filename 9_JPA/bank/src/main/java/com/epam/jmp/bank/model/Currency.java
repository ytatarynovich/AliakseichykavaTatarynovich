package com.epam.jmp.bank.model;

import com.epam.jmp.bank.exceptions.CurrencyNotFoundException;

/**
 * @author Hanna_Aliakseichykava
 */
public enum Currency {

	BY	(),
	USD	(),
	EU	();

	public static Currency findByName(String name) {
		name = name != null ? name.toUpperCase() : name;
		for(Currency currency : values()) {
			if(currency.name().toUpperCase().equals(name)) {
				return currency;
			}
		}
		throw new CurrencyNotFoundException(name);
	}
}
