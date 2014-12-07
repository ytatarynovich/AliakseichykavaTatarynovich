package com.epam.jmp.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Hanna_Aliakseichykava
 */
@Entity
public class Bank {

	@Id
	private long id;

	private String name;

	public Bank() {}

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

	public String getName() {
		return name;
	}
}
