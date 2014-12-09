package com.epam.jmp.bank.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

		Account account = em.find(Account.class,  id);

		if(account == null) {
			throw new AccountNotFoundException(id);
		}

		return account;
	}

	@Override
	public List<Account>getAllByBankId(Long bankId) {

		return em.createNamedQuery("Account.findByBankId", Account.class)
				.setParameter("bankId", bankId)
				.getResultList();
	}

	@Override
	public List<Account> getAccountByFirstOrLastName(Long bankId, String name) {

		return em.createNamedQuery("Account.findByByFirstOrLastName", Account.class)
				.setParameter("bankId", bankId)
				.setParameter("name", name)
				.getResultList();
	}

	@Override
	public void update(Account account) {

		Account savedAccount = getById(account.getId());

		em.getTransaction().begin();
		savedAccount.setAmount(account.getCurrency(), account.getAmount());
		em.getTransaction().commit();

		//TODO: update Person
	}

	@Override
	public long create(Long bankId, String firstName, String lastName) {

		Bank bank = bankDao.getById(bankId);

		Long personId = personDao.create(firstName, lastName);
		Person person = personDao.getById(personId);

		Long id = generateId();

		Account account = new Account(id, person, bank, DEFAULT_CURRENCY, DEFAULT_AMOUNT);

		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();

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

