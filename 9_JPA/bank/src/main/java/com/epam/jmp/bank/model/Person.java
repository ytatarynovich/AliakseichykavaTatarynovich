package com.epam.jmp.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Hanna_Aliakseichykava
 */
@Entity
public class Person {

	@Id
	private long id;
	private String firstName;
	private String lastName;

	public Person() {}

	public Person(Long id, String firstName, String lastName) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "PERSON " + id + ": " + lastName + ", " + firstName;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
