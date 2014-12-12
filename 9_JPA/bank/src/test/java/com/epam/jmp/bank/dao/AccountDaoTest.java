package com.epam.jmp.bank.dao;

import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.jmp.bank.exceptions.AccountNotFoundException;
import com.epam.jmp.bank.exceptions.BankNotFoundException;
import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.model.Currency;

/**
 * @author Hanna_Aliakseichykava
 */
public class AccountDaoTest extends DBUnitTestCase {

	private AccountDao dao;

	@Before
	public void setUp() throws Exception {
		dao = applicationContext.getBean(AccountDao.class);
	}

	@Override
	protected String getDataPath() {
		return "dao/account-data.xml";
	}

	@Override
	protected String getTableName() {
		return "account";
	}

	private static final String TEST_FIRST_NAME = "Ann";
	private static final String TEST_LAST_NAME = "Aleks";

	@Test
	public void testGetAccountById() throws Exception {
		long id = 1L;
		Account account = dao.getById(id);
		Assert.assertEquals(id, account.getId());
	}

	@Test(expected = AccountNotFoundException.class)
	public void testGetAccountByIdNotFound() {
		long nonExistentId = 10;
		dao.getById(nonExistentId);
	}

	@Test
	public void testGetAllAccounts() throws Exception {

		IDataSet actualData = getActualData();
		long bankId = new Long(actualData.getTable("bank").getValue(0, "id").toString());

		List<Account> accounts = dao.getAllByBankId(bankId);

		IDataSet expectedData = loadDataSet(getDataPath());

		actualData = getActualData();

		Assertion.assertEquals(expectedData.getTable(getTableName()), actualData.getTable(getTableName()));
		Assert.assertEquals(expectedData.getTable(getTableName()).getRowCount(), accounts.size());
	}

	private static final String TEST_FIRST_NAME_FOR_SEARCH = "Sidor";
	private static final String TEST_LAST_NAME_FOR_SEARCH = "Sidorov";
	private static final String NOT_EXISTENT_NAME = "Test";

	@Test
	public void testGetAccountByFirstOrLastName() throws Exception {
	
		IDataSet actualData = getActualData();
		long bankId = new Long(actualData.getTable("bank").getValue(0, "id").toString());

		IDataSet expectedData = loadDataSet(getDataPath());

		List<Account> accounts = dao.getAccountByFirstOrLastName(bankId, TEST_FIRST_NAME_FOR_SEARCH);

		Assertion.assertEquals(expectedData.getTable(getTableName()), actualData.getTable(getTableName()));
		Assert.assertEquals(1, accounts.size());

		accounts = dao.getAccountByFirstOrLastName(bankId, TEST_LAST_NAME_FOR_SEARCH);

		Assertion.assertEquals(expectedData.getTable(getTableName()), actualData.getTable(getTableName()));
		Assert.assertEquals(1, accounts.size());

		accounts = dao.getAccountByFirstOrLastName(bankId, NOT_EXISTENT_NAME);
		Assert.assertEquals(0, accounts.size());
	}

	private static final Currency NEW_CURRENCY = Currency.USD;
	private static final double NEW_AMOUNT = 1000;

	@Test
	public void testUpdate() throws Exception {
		int rowNumber = 0;
		IDataSet actualData = getActualData();
		long id = new Long(actualData.getTable(getTableName()).getValue(rowNumber, "id").toString());

		Account account = dao.getById(id);
		account.setAmount(NEW_CURRENCY, NEW_AMOUNT);
		dao.update(account);

		IDataSet expectedData = loadDataSet("dao/account-data-update.xml");

		actualData = getActualData();

		Assertion.assertEquals(expectedData.getTable(getTableName()), actualData.getTable(getTableName()));

		account = dao.getById(id);
		Assert.assertEquals(NEW_CURRENCY, account.getCurrency());
		Assert.assertEquals(NEW_AMOUNT, account.getAmount(), 0);
	}

	@Test
	public void testPersist() throws Exception {

		//IDataSet actualData = getActualData();
		//long bankId = new Long(actualData.getTable("bank").getValue(0, "id").toString());
		long bankId = 1L;

		Long id = dao.create(bankId, TEST_FIRST_NAME, TEST_LAST_NAME);
		log.info("\n\n!!! New Account: " + id + " \n\n");

		IDataSet expectedData = loadDataSet("dao/account-data-save.xml");
 
		IDataSet actualData = getActualData();

		String[] ignore = {"id", "personid"};
		Assertion.assertEqualsIgnoreCols(expectedData, actualData, getTableName(), ignore);

		log.info("\n\n!!! " + expectedData + " \n\n");
		log.info("\n\n!!! " + actualData + " \n\n");
		Assertion.assertEqualsIgnoreCols(expectedData, actualData, "person", ignore);
	}

	@Test(expected = BankNotFoundException.class)
	public void testPersistBankNotFound() {
		long notExistentBankId = 100L;

		dao.create(notExistentBankId, TEST_FIRST_NAME, TEST_LAST_NAME);
	}

}
