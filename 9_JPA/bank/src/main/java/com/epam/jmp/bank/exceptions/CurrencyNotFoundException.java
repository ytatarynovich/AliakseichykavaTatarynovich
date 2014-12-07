package com.epam.jmp.bank.exceptions;

/**
 * @author Hanna_Aliakseichykava
 */
public class CurrencyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CurrencyNotFoundException(int code) {
		super("Currency with code [" + code + "] can not be found.");
	}

	public CurrencyNotFoundException(String name) {
		super("Currency with name [" + name + "] can not be found.");
	}
}
