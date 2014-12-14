package com.epam.jmp.bank.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.jmp.bank.dao.AccountDao;
import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.services.AccountService;
import com.google.common.annotations.VisibleForTesting;
import com.google.gson.Gson;

/**
 * @author Hanna_Aliakseichykava
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Override
	public long createAccount(Long bankId, String firstName, String lastName) {
		return accountDao.create(bankId, firstName, lastName);
	}

	@Override
	public Account findAccountById(long id) {
		return accountDao.getById(id);
	}

	@Override
	public List<Account> getAllAccounts(Long bankId) {
		return accountDao.getAllByBankId(bankId);
	}

	@Override
	public List<Account> findAccountByFirstOrLastName(Long bankId, String name) {
		return accountDao.getAccountByFirstOrLastName(bankId, name);
	}

	@Override
	public void updateAccount(Account account) {
		accountDao.update(account);
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
	public void setDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

}
