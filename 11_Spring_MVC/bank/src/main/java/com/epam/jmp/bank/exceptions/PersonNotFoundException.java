package com.epam.jmp.bank.exceptions;

/**
 * @author Hanna_Aliakseichykava
 */
public class PersonNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PersonNotFoundException(long id) {
		super("Person with id [" + id + "] can not be found.");
	}
}
