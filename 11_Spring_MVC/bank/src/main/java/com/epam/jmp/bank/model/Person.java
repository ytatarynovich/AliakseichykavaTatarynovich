package com.epam.jmp.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.common.annotations.VisibleForTesting;

/**
 * @author Hanna_Aliakseichykava
 */
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;

	public Person() {}

	public Person(String firstName, String lastName) {

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

	@VisibleForTesting
	public void setId(Long id) {
		this.id = id;
	}

}
