package com.epam.jmp.bank.services;

import java.util.List;

import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.model.dto.AccountDto;

/**
 * @author Hanna_Aliakseichykava
 */
public interface AccountService {

	public long createAccount(Long bankId, String firstName, String lastName);

	public long createAccount(AccountDto account);

	public Account findAccountById(long id);

	public List<Account> findAccountByFirstOrLastName(Long bankId, String name);

	public List<Account> getAllAccounts(Long bankId);

	public void updateAccount(Account account);

	public String getBankAccountAsJson(Long accountId);

	public String getBankAccountsAsJson(Long bankId);

}
