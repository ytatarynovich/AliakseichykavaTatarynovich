package com.epam.jmp.concurrency.exceptions;

/**
 * @author Hanna_Aliakseichykava
 */
public class CurrencyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CurrencyNotFoundException(int code) {
		super("Currency with code [" + code + "] can not be found.");
	}
}
