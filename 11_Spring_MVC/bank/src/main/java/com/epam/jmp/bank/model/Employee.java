package com.epam.jmp.bank.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author Hanna_Aliakseichykava
 */
@NamedQueries({
@NamedQuery(
	name="Employee.findByLogin", 
	query="select e from Employee e where e.login = :login")
})
@Entity
public class Employee {

	@Id
	private long id;
	private String login;
	private String firstName;
	private String lastName;
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	public Employee() {}

	public Employee(long id, String login, String firstName, String lastName, Role role) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
