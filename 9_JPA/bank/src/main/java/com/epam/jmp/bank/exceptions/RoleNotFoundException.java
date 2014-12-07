package com.epam.jmp.bank.exceptions;

public class RoleNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RoleNotFoundException(int code) {
		super("Role with code [" + code + "] can not be found.");
	}

	public RoleNotFoundException(String name) {
		super("Role with name [" + name + "] can not be found.");
	}
}
