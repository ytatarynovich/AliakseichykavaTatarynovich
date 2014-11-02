package com.epam.jmp.bank.model;

/**
 * @author Hanna_Aliakseichykava
 */
public class Person {

	private long id;
	private String firstName;
	private String lastName;

	public Person(Long id, String firstName, String lastName) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "PERSON " + id + ": " + lastName + ", " + firstName;
	}
}
