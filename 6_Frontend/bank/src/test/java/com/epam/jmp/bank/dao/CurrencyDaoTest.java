package com.epam.jmp.bank.dao;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.epam.jmp.bank.model.Currency;

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
		return "currency";
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		Currency.setDefaultValues();
	}

	@Test
	public void testSynchronizeCurrencies() throws Exception {

		dao.synchronizeCurrencies();

		IDataSet expectedData = loadDataSet(getDataPath());
		IDataSet actualData = getActualData();

		String[] ignore = {"id"};
		Assertion.assertEqualsIgnoreCols(expectedData, actualData, getTableName(), ignore);
	}

	@Test
	public void testUpdateCurrency() throws Exception {
		Currency currency = Currency.USD;
		double newRate = 12000;

		Assert.assertNotEquals(newRate, currency.getRate());

		dao.updateCurrency(currency.name(), newRate);

		IDataSet expectedData = loadDataSet("dao/currency-data-update.xml");

		IDataSet actualData = getActualData();

		String[] ignore = {"id"};
		Assertion.assertEqualsIgnoreCols(expectedData, actualData, getTableName(), ignore);

		Assert.assertNotEquals(newRate, currency.getRate());
		dao.synchronizeCurrencies();
		Assert.assertEquals(newRate, currency.getRate(), 0);
	}

}
