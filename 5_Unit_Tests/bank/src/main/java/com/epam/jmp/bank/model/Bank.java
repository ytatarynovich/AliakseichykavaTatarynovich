package com.epam.jmp.bank.model;

/**
 * @author Hanna_Aliakseichykava
 */
public class Bank {

	private long id;
	private String name;

	public Bank(Long id, String name) {

		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "BANK " + id + ": \"" + name + "\"";
	}

	public long getId() {
		return id;
	}

}
