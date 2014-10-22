package com.epam.jmp.concurrency.model;

/**
 * @author Hanna_Aliakseichykava
 */
public class Person {

	private static long idCounter = 0;

	private long id;
	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName) {

		this.id = ++idCounter;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "[Person " + id + ": " + lastName + ", " + firstName + "]";
	}
	
	public boolean isMatchByName(String name) {

		if(name.trim().equals("")) {
			return false;
		}

		return firstName.contains(name) || lastName.contains(name);
	}
}
