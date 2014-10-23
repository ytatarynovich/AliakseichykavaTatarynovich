package com.epam.jmp.concurrency.exceptions;

/**
 * @author Hanna_Aliakseichykava
 */
public class ActionNotSupportedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ActionNotSupportedException(int code) {
		super("Option [" + code + "] is not supported, please, select another one from the menu.");
	}
	
}
