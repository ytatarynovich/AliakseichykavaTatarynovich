package com.epam.jmp.bank.dao;

import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.jmp.bank.exceptions.BankNotFoundException;
import com.epam.jmp.bank.model.Bank;

/**
 * @author Hanna_Aliakseichykava
 */
public class BankDaoTest extends DBUnitTestCase {

	private BankDao dao;

	@Before
	public void setUp() throws Exception {
		dao = applicationContext.getBean(BankDao.class);
	}

	@Override
	protected String getDataPath() {
		return "dao/bank-data.xml";
	}

	@Override
	protected String getTableName() {
		return "bank";
	}

	@Test
	public void testGetAll() throws Exception {
		List<Bank> banks = dao.getAll();

		IDataSet expectedData = loadDataSet(getDataPath());

		IDataSet actualData = getActualData();

		Assertion.assertEquals(expectedData.getTable(getTableName()), actualData.getTable(getTableName()));
		Assert.assertEquals(expectedData.getTable(getTableName()).getRowCount(), banks.size());
	}

	@Test
	public void testGetBankById() throws Exception {
		long id = 1L;

		Bank bank = dao.getById(id);
		Assert.assertEquals(id, bank.getId());
	}

	@Test(expected = BankNotFoundException.class)
	public void testGetBankByIdNotFound() {
		long nonExistentId = 10;
		dao.getById(nonExistentId);
	}
}
