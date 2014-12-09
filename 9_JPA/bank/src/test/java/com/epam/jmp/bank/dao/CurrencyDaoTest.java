package com.epam.jmp.bank.dao;

import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.model.CurrencyRate;

/**
 * @author Hanna_Aliakseichykava
 */
@RunWith(value = BlockJUnit4ClassRunner.class)
public class CurrencyDaoTest extends DBUnitTestCase {

	private CurrencyDao dao = new CurrencyDao();

	@Override
	protected String getDataPath() {
		return "dao/currency-data.xml";
	}

	@Override
	protected String getTableName() {
		return "CurrencyRate";
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testGetAll() throws Exception {
		List<CurrencyRate> currencies = dao.getAll();

		IDataSet expectedData = loadDataSet(getDataPath());

		IDataSet actualData = getActualData();

		Assertion.assertEquals(expectedData.getTable(getTableName()), actualData.getTable(getTableName()));
		Assert.assertEquals(expectedData.getTable(getTableName()).getRowCount(), currencies.size());
	}

	@Test
	public void testFindByName() throws Exception {

		assertEquals(dao.findByName("BY").getCurrency(), Currency.BY);
		assertEquals(dao.findByName("EU").getCurrency(), Currency.EU);
		assertEquals(dao.findByName("USD").getCurrency(), Currency.USD);
	}

	@Test
	public void testUpdateCurrency() throws Exception {
		CurrencyRate currency = dao.findByName("USD");
		double newRate = 12000;

		Assert.assertNotEquals(newRate, currency.getRate());

		dao.updateCurrency(currency.getCurrency().name(), newRate);

		IDataSet expectedData = loadDataSet("dao/currency-data-update.xml");

		IDataSet actualData = getActualData();

		String[] ignore = {"id"};
		Assertion.assertEqualsIgnoreCols(expectedData, actualData, getTableName(), ignore);

		currency = dao.findByName("USD");
		Assert.assertEquals(newRate, currency.getRate(), 0);
	}

}
