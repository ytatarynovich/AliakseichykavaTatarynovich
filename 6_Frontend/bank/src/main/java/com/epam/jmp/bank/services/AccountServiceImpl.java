package com.epam.jmp.bank.services;

import java.sql.SQLException;
import java.util.List;

import com.epam.jmp.bank.dao.AccountDao;
import com.epam.jmp.bank.model.Account;

/**
 * @author Hanna_Aliakseichykava
 */
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	public AccountServiceImpl() {
		this.accountDao = new AccountDao();
	}

	@Override
	public long createAccount(Long bankId, String firstName, String lastName) {
		try {
			return accountDao.persist(bankId, firstName, lastName);
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
	public List<Account> getAllAccounts(Long bankId) {
		try {
			return accountDao.getAllAccounts(bankId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Account> findAccountByFirstOrLastName(Long bankId, String name) {

		try {
			return accountDao.getAccountByFirstOrLastName(bankId, name);
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
