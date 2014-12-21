package com.epam.jmp.bank.exceptions;

/**
 * @author Hanna_Aliakseichykava
 */
public class BankNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BankNotFoundException(long id) {
		super("Bank with id [" + id + "] can not be found.");
	}
}
