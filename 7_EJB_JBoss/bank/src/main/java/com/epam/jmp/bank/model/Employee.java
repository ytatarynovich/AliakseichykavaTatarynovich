package com.epam.jmp.bank.model;

/**
 * @author Hanna_Aliakseichykava
 */
public class Employee {
	
	private long id;
	private String login;
	private String firstName;
	private String lastName;
	private Role role;

	public Employee(long id, String login, String firstName, String lastName,
			Role role) {
		super();
		this.id = id;
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	@Override
	public String toString() {
		return "EMPLOYEE " + id + ": " + login;
	}

	public long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
