package com.epam.jmp.bank.controller;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.model.Bank;
import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.model.Person;
import com.epam.jmp.bank.services.AccountService;
import com.epam.jmp.bank.services.impl.AccountServiceImpl;

public class AccountControllerTest {

	private static final Currency START_CURRENCY = Currency.BY;
	private static final double START_AMOUNT = 400D;

	private static final Long BANK_ID = 11L;
	private static final Long PERSON_ID = 123L;
	private static final Long ACCOUNT_ID = 1234L;
	private Account account;

	private AccountService service;
	private AccountController controller = new AccountController();

	@Before
	public void setUp() {

		Bank bank = new Bank(BANK_ID, "Some bank");
		Person person = new Person("Ivan", "Ivanov");
		person.setId(PERSON_ID);
		account = new Account(person, bank, START_CURRENCY, START_AMOUNT);
		account.setId(ACCOUNT_ID);

		service = Mockito.mock(AccountServiceImpl.class);
		when(service.findAccountById(ACCOUNT_ID)).thenReturn(account);

		controller.setService(service);
	}

	@Test
	public void testUpdateAccount() {
		String newCurrency = "USD";
		double newAmount = 1000;

		controller.updateAccount(ACCOUNT_ID, newCurrency, newAmount);

		Mockito.verify(service).updateAccount(account);
	}

	@Test
	public void testCreateAccount() {

		String fName = "fname";
		String lName = "lname";

		controller.createAccount(BANK_ID, fName, lName);

		Mockito.verify(service).createAccount(BANK_ID, fName, lName);
	}
}
