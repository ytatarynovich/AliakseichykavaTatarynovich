package com.epam.jmp.bank.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * @author Hanna_Aliakseichykava
 */
@NamedQueries({
@NamedQuery(
	name="Account.findByBankId", 
	query="select a from Account a where a.bank.id = :bankId"),
@NamedQuery(
	name="Account.findByByFirstOrLastName", 
	query="select a from Account a where a.bank.id = :bankId AND (a.person.firstName = :name OR a.person.lastName = :name)")
})
@Entity
public class Account {

	@Id
	private long id;

	@OneToOne
	@JoinColumn(name = "personid")
	private Person person;

	@ManyToOne
	@JoinColumn(name = "bankid")
	private Bank bank;

	@Enumerated(EnumType.STRING)
	private Currency currency;

	private double amount;

	public Account() {}

	public Account(long id, Person person, Bank bank, Currency currency, double amount) {
		this.id = id;
		this.person = person;
		this.bank = bank;
		this.currency = currency;
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

	public void setAmount(Currency currency, double amount) {
		this.currency = currency;
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public double getAmount() {
		return amount;
	}

}
