package com.epam.jmp.bank.dao;

import java.util.List;

import com.epam.jmp.bank.model.Account;

/**
 * @author Hanna_Aliakseichykava
 */
public interface AccountDao {

	public Account getById(long id);

	public List<Account> getAllByBankId(Long bankId);

	public List<Account> getAccountByFirstOrLastName(Long bankId, String name);

	public void update(Account account);

	public long create(Long bankId, String firstName, String lastName);

}
