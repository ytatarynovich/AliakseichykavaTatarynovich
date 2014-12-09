package com.epam.jmp.bank.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.epam.jmp.bank.dao.AccountDao;
import com.epam.jmp.bank.model.Account;
import com.google.common.annotations.VisibleForTesting;
import com.google.gson.Gson;

/**
 * @author Hanna_Aliakseichykava
 */
@Stateless
public class AccountServiceImpl implements AccountService {

	private static final long serialVersionUID = 2L;
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
		return accountDao.getAccountById(id);
	}

	@Override
	public List<Account> getAllAccounts(Long bankId) {
		return accountDao.getAllAccounts(bankId);
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

	private static final String ID = "id";
	private static final String CURRENCY = "currency";
	private static final String AMOUNT = "amount";
	private static final String FIRST_NAME = "firstname";
	private static final String LAST_NAME = "lastname";
	private static final String AS_STRING = "asstring";

	private Map<String, String> getAccountAsMap(Account account) {

		Map<String, String> map = new HashMap<String, String>();
		map.put(ID, String.valueOf(account.getId()));
		map.put(CURRENCY, account.getCurrency().name());
		map.put(AMOUNT, String.valueOf(account.getAmount()));
		map.put(FIRST_NAME, account.getPerson().getFirstName());
		map.put(LAST_NAME, account.getPerson().getLastName());
		map.put(AS_STRING, account.toString());

		return map;
	}

	private String getAccountsAsJson(List<Account> accounts) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for(Account account : accounts) {
			list.add(getAccountAsMap(account));
		}
		return new Gson().toJson(list);
	}

	public String getBankAccountAsJson(Long accountId) {
		Map<String, String> map = getAccountAsMap(findAccountById(accountId));
		return new Gson().toJson(map);
	}

	public String getBankAccountsAsJson(Long bankId) {
		return getAccountsAsJson(getAllAccounts(bankId));
	}

	@VisibleForTesting
	void setDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

}
