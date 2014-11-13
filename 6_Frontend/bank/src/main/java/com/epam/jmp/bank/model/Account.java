package com.epam.jmp.bank.model;

/**
 * @author Hanna_Aliakseichykava
 */
public class Account {

	private long id;
	private Person person;

	private Currency accountCurrency;
	private double amount;

	public Account(long id, Person person, Currency accountCurrency, double amount) {
		this.id = id;
		this.person = person;
		this.accountCurrency = accountCurrency;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ACCOUNT " + id + " for " + person;
	}

	public long getId() {
		return id;
	}

	public Person getPerson() {
		return person;
	}

	public void setAmount(Currency accountCurrency, double amount) {
		this.accountCurrency = accountCurrency;
		this.amount = amount;
	}

	public Currency getAccountCurrency() {
		return accountCurrency;
	}

	public double getAmount() {
		return amount;
	}

}
