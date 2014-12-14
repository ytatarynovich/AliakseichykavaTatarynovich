package com.epam.jmp.bank.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jmp.bank.dao.AccountDao;
import com.epam.jmp.bank.dao.BankDao;
import com.epam.jmp.bank.dao.PersonDao;
import com.epam.jmp.bank.exceptions.AccountNotFoundException;
import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.model.Bank;
import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.model.Person;
import com.google.common.annotations.VisibleForTesting;

@Component
public class AccountDaoImpl extends AbstractDao implements AccountDao {

	private static final Currency DEFAULT_CURRENCY = Currency.BY;
	private static final double DEFAULT_AMOUNT = 0;

	@Autowired
	private PersonDao personDao;

	@Autowired
	private BankDao bankDao;

	@Override
	public String getTableName() {
		return "Account";
	}

	@Override
	public Account getById(long id) {

		Account account = getEntityManager().find(Account.class,  id);

		if(account == null) {
			throw new AccountNotFoundException(id);
		}

		return account;
	}

	@Override
	public List<Account>getAllByBankId(Long bankId) {

		return getEntityManager().createNamedQuery("Account.findByBankId", Account.class)
				.setParameter("bankId", bankId)
				.getResultList();
	}

	@Override
	public List<Account> getAccountByFirstOrLastName(Long bankId, String name) {

		return getEntityManager().createNamedQuery("Account.findByByFirstOrLastName", Account.class)
				.setParameter("bankId", bankId)
				.setParameter("name", name)
				.getResultList();
	}

	@Override
	@Transactional
	public void update(Account account) {

		Account savedAccount = getById(account.getId());

		savedAccount.setAmount(account.getCurrency(), account.getAmount());
		getEntityManager().flush();

		//TODO: update Person
	}

	@Override
	@Transactional
	public long create(Long bankId, String firstName, String lastName) {

		Bank bank = bankDao.getById(bankId);

		Long personId = personDao.create(firstName, lastName);
		Person person = personDao.getById(personId);

		Account account = new Account(person, bank, DEFAULT_CURRENCY, DEFAULT_AMOUNT);

		getEntityManager().persist(account);
		getEntityManager().flush();

		return account.getId();
	}

	@VisibleForTesting
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@VisibleForTesting
	public void setBankDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}
}

