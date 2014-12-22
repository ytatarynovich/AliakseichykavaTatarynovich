package com.epam.jmp.bank.model.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AccountDto {

	@NotNull
	private Long bankId;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;

	public AccountDto() {
	}

	public AccountDto(Long bankId, String firstName, String lastName) {
		super();
		this.bankId = bankId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return bankId + " " +
		firstName + " " +
		lastName;
	}

}
