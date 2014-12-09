package com.epam.jmp.bank.services;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.epam.jmp.bank.dao.AccountDao;
import com.epam.jmp.bank.dao.BankDao;
import com.epam.jmp.bank.dao.PersonDao;
import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.model.Bank;
import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.model.Person;
import com.epam.jmp.bank.services.impl.AccountServiceImpl;
import com.epam.jmp.bank.dao.impl.AccountDaoImpl;

/**
 * @author Hanna_Aliakseichykava
 */
public class AccountServiceImplTest {

	private static final String EXPECTED_ACCOUNT_JSON = "{\"amount\":\"400.0\",\"id\":\"1234\",\"asstring\":\"ACCOUNT 1234 for PERSON 123: Ivanov, Ivan\",\"lastname\":\"Ivanov\",\"firstname\":\"Ivan\",\"currency\":\"BY\"}";
	private static final String EXPECTED_ACCOUNTS_JSON = "[" + EXPECTED_ACCOUNT_JSON + "]";

	private static final Long BANK_ID = 11L;
	private static final Long PERSON_ID = 123L;
	private static final Long ACCOUNT_ID = 1234L;

	AccountServiceImpl service = new AccountServiceImpl();

	@Before
	public void setUp() throws SQLException {

		Bank bank = new Bank(BANK_ID, "Some bank");
		Person person = new Person(PERSON_ID, "Ivan", "Ivanov");
		Account account = new Account(ACCOUNT_ID, person, bank, Currency.BY, 400D);

		PersonDao personDao = Mockito.mock(PersonDao.class);
		when(personDao.getById(PERSON_ID)).thenReturn(person);

		BankDao bankDao = Mockito.mock(BankDao.class);
		when(bankDao.getById(BANK_ID)).thenReturn(bank);

		AccountDao accountDao = Mockito.mock(AccountDao.class);
		when(accountDao.getAllByBankId(BANK_ID)).thenReturn(Arrays.asList(new Account[] {account}));
		when(accountDao.getById(ACCOUNT_ID)).thenReturn(account);

		((AccountDaoImpl)accountDao).setPersonDao(personDao);
		((AccountDaoImpl)accountDao).setBankDao(bankDao);

		service.setDao(accountDao);
	}

	@Test
	public void testGetBankAccountAsJson() {

		Assert.assertThat(service.getBankAccountAsJson(ACCOUNT_ID), equalTo(EXPECTED_ACCOUNT_JSON));
	}

	@Test
	public void testGetBankAccountsAsJson() {

		Assert.assertThat(service.getBankAccountsAsJson(BANK_ID), equalTo(EXPECTED_ACCOUNTS_JSON));
	}

}
