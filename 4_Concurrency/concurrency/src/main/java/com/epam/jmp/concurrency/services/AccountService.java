package com.epam.jmp.concurrency.services;

import java.util.List;

import com.epam.jmp.concurrency.model.Account;

/**
 * @author Hanna_Aliakseichykava
 */
public interface AccountService {

	public long createAccount(String firstName, String lastName);

	public Account findAccountById(long id);

	public List<Account> findAccountByFirstOrLastName(String name);
	
	public List<Account> getAllAccounts();

}
