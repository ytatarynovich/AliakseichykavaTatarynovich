package com.epam.jmp.concurrency.model;

/**
 * @author Hanna_Aliakseichykava
 */
public class Account {

	private static long idCounter = 0;

	private long id;
	private Person person;

	private Currency accountCurrency;
	private double amount;

	public Account(String firstName, String lastName) {

		this.id = ++idCounter;
		this.person = new Person(firstName, lastName);
	}

	@Override
	public String toString() {
		return "ACCOUNT " + id + " for " + person + "; Amount: " + amount + "(" + accountCurrency +")";
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
