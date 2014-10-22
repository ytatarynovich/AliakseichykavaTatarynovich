package com.epam.jmp.concurrency.services;

import java.util.ArrayList;
import java.util.List;

import com.epam.jmp.concurrency.model.Account;
import com.epam.jmp.concurrency.model.Bank;
import com.epam.jmp.concurrency.model.Person;

/**
 * @author Hanna_Aliakseichykava
 */
public class AccountServiceImpl implements AccountService {

	private Bank bank;

	public AccountServiceImpl(Bank bank) {
		this.bank = bank;
	}

	@Override
	public long createAccount(String firstName, String lastName) {
		return bank.addAccount(firstName, lastName);
	}

	@Override
	public Account findAccountById(long id) {
		return bank.getAccountById(id);
	}

	@Override
	public List<Account> findAccountByFirstOrLastName(String name) {

		List<Account> accounts = new ArrayList<Account>();
		for(Account account : bank.getAccounts()) {
			if(account.getPerson().isMatchByName(name)) {
				accounts.add(account);
			}
		}

		return accounts;
	}

	@Override
	public List<Account> getAllAccounts() {
		return bank.getAccounts();
	}

}
