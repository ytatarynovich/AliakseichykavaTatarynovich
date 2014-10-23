package com.epam.jmp.concurrency.model;

import java.util.ArrayList;
import java.util.List;

import com.epam.jmp.concurrency.exceptions.AccountNotFoundException;

/**
 * @author Hanna_Aliakseichykava
 */
public class Bank {
	
	private static long idCounter = 0;

	private long id;
	private String name;
	
	private List<Account> accounts;

	public Bank(String name) {

		this.id = ++idCounter;
		this.name = name;

		accounts = new ArrayList<Account>();
	}

	@Override
	public String toString() {
		return "BANK " + id + ": \"" + name + "\"";
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public long addAccount(String firstName, String lastName) {
		Account account = new Account(firstName, lastName);
		accounts.add(account);
		return account.getId();
	}

	public Account getAccountById(long accountId) {
		for(Account account : accounts) {
			if(account.getId() == accountId) {
				return account;
			}
		}
		throw new AccountNotFoundException(accountId);
	}
}
