package com.epam.jmp.bank.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.mockito.Mockito;

import com.epam.jmp.bank.dao.BankDao;
import com.epam.jmp.bank.dao.PersonDao;
import com.epam.jmp.bank.dao.impl.AccountDaoImpl;
import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.model.Bank;
import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.model.Person;
import com.epam.jmp.bank.services.AccountService;

public class AccountControllerTest {

	private static final Long BANK_ID = 11L;
	private static final Long PERSON_ID = 123L;
	private static final Long ACCOUNT_ID = 1234L;

	@Before
	public void setUp() {

		Bank bank = new Bank(BANK_ID, "Some bank");
		Person person = new Person("Ivan", "Ivanov");
		person.setId(PERSON_ID);
		Account account = new Account(person, bank, Currency.BY, 400D);
		account.setId(ACCOUNT_ID);

		/*PersonDao personDao = Mockito.mock(PersonDao.class);
		when(personDao.getById(PERSON_ID)).thenReturn(person);

		BankDao bankDao = Mockito.mock(BankDao.class);
		when(bankDao.getById(BANK_ID)).thenReturn(bank);

		AccountDaoImpl accountDao = Mockito.mock(AccountDaoImpl.class);
		when(accountDao.getAllByBankId(BANK_ID)).thenReturn(Arrays.asList(new Account[] {account}));
		when(accountDao.getById(ACCOUNT_ID)).thenReturn(account);

		accountDao.setPersonDao(personDao);
		accountDao.setBankDao(bankDao);

		service.setDao(accountDao);*/
		
		AccountService accountService = Mockito.mock(AccountService.class);
	}
}
