package com.epam.jmp.bank.services;

import java.sql.SQLException;
import java.util.List;

import com.epam.jmp.bank.dao.AccountDao;
import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.model.Bank;

/**
 * @author Hanna_Aliakseichykava
 */
public class AccountServiceImpl implements AccountService {

	private Bank bank;

	private AccountDao accountDao;

	public AccountServiceImpl(Bank bank) {
		this.bank = bank;
		this.accountDao = new AccountDao();
	}

	@Override
	public long createAccount(String firstName, String lastName) {
		try {
			return accountDao.persist(bank.getId(), firstName, lastName);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Account findAccountById(long id) {
		try {
			return accountDao.getAccountById(id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Account> getAllAccounts() {
		try {
			return accountDao.getAllAccounts(bank.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Account> findAccountByFirstOrLastName(String name) {

		try {
			return accountDao.getAccountByFirstOrLastName(bank.getId(), name);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateAccount(Account account) {

		try {
			accountDao.update(account);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
