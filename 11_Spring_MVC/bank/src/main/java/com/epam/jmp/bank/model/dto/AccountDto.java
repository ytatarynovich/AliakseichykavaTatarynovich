package com.epam.jmp.bank.model.dto;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.NotEmpty;;

public class AccountDto {

	@NotEmpty
	private Long bankId;
	@Range(min = 3, max = 20)
	private String firstName;
	@Range(min = 3, max = 20)
	private String lastName;

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
}
