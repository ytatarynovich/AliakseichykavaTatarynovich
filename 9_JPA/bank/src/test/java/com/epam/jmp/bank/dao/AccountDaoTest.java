package com.epam.jmp.bank.dao;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.epam.jmp.bank.exceptions.AccountNotFoundException;
import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.model.Currency;

/**
 * @author Hanna_Aliakseichykava
 */
@RunWith(value = BlockJUnit4ClassRunner.class)
public class AccountDaoTest extends DBUnitTestCase {

	private AccountDao dao = new AccountDao();

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
		int rowNumber = 0;
		IDataSet actualData = getActualData();
		long id = new Long(actualData.getTable(getTableName()).getValue(rowNumber, "id").toString());
		long expecedPersonId = new Long(actualData.getTable(getTableName()).getValue(rowNumber, "personid").toString());

		Account account = dao.getAccountById(id);
		Assert.assertEquals(id, account.getId());
		Assert.assertEquals(expecedPersonId, account.getPerson().getId());
	}

	@Test(expected = AccountNotFoundException.class)
	public void testGetAccountByIdNotFound() throws SQLException {
		long nonExistentId = 10;
		dao.getAccountById(nonExistentId);
	}

	@Test
	public void testGetAllAccounts() throws Exception {
	
		IDataSet actualData = getActualData();
		long bankId = new Long(actualData.getTable("bank").getValue(0, "id").toString());
		
		List<Account> accounts = dao.getAllAccounts(bankId);

		IDataSet expectedData = loadDataSet(getDataPath());

		actualData = getActualData();

		Assertion.assertEquals(expectedData.getTable(getTableName()), actualData.getTable(getTableName()));
		Assert.assertEquals(expectedData.getTable(getTableName()).getRowCount(), accounts.size());
	}

	@Test
	public void testPersist() throws Exception {

		IDataSet actualData = getActualData();
		long bankId = new Long(actualData.getTable("bank").getValue(0, "id").toString());

		dao.persist(bankId, TEST_FIRST_NAME, TEST_LAST_NAME);

		IDataSet expectedData = loadDataSet("dao/account-data-save.xml");
 
		actualData = getActualData();

		String[] ignore = {"id", "personid"};
		Assertion.assertEqualsIgnoreCols(expectedData, actualData, getTableName(), ignore);

		Assertion.assertEqualsIgnoreCols(expectedData, actualData, "person", ignore);
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

		Account account = dao.getAccountById(id);
		account.setAmount(NEW_CURRENCY, NEW_AMOUNT);
		dao.update(account);

		IDataSet expectedData = loadDataSet("dao/account-data-update.xml");

		actualData = getActualData();

		Assertion.assertEquals(expectedData.getTable(getTableName()), actualData.getTable(getTableName()));

		account = dao.getAccountById(id);
		Assert.assertEquals(NEW_CURRENCY, account.getCurrency());
		Assert.assertEquals(NEW_AMOUNT, account.getAmount(), 0);
	}
}
