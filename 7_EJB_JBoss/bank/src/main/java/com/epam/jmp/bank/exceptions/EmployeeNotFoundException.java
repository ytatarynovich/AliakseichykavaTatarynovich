package com.epam.jmp.bank.exceptions;

/**
 * @author Hanna_Aliakseichykava
 */
public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String login) {
		super("Employee with login [" + login + "] can not be found.");
	}

	public EmployeeNotFoundException(Long id) {
		super("Employee with id [" + id + "] can not be found.");
	}
}
