package com.epam.jmp.bank.services;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.epam.jmp.bank.dao.CurrencyDao;
import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.model.CurrencyRate;
import com.epam.jmp.bank.services.impl.CurrencyServiceImpl;

/**
 * @author Hanna_Aliakseichykava
 */
public class CurrencyServiceImplTest {

	private static final String EXPECTED_JSON = "[{\"rate\":\"1.0\",\"name\":\"BY\"},{\"rate\":\"5.0\",\"name\":\"USD\"}]";

	CurrencyServiceImpl service = new CurrencyServiceImpl();

	@Before
	public void setUp() {
		CurrencyRate cr1 = new CurrencyRate(1, Currency.BY);
		CurrencyRate cr2 = new CurrencyRate(5, Currency.USD);

		CurrencyDao dao = Mockito.mock(CurrencyDao.class);
		when(dao.getAll()).thenReturn(Arrays.asList(new CurrencyRate[] {cr1, cr2}));

		service.setDao(dao);
	}

	@Test
	public void testGetAllCurrenciesAsJson() {

		Assert.assertThat(service.getAllCurrenciesAsJson(), equalTo(EXPECTED_JSON));
	}

	@Test
	public void testExchangeCurrency() {
		int exchangeRate = 3;
		double rateFrom = 2D;
		double rateTo = rateFrom * exchangeRate;

		CurrencyRate currencyFrom = new CurrencyRate(rateFrom, Currency.BY);
		CurrencyRate currencyTo = new CurrencyRate(rateTo, Currency.USD);
		double amount = 5000;

		double exchangedAmount = service.exchangeCurrency(amount, currencyFrom, currencyTo);
		Assert.assertThat(exchangedAmount, closeTo(amount / exchangeRate, 0.00000001));

		exchangedAmount = service.exchangeCurrency(amount, currencyTo, currencyFrom);
		Assert.assertThat(exchangedAmount, equalTo(amount * exchangeRate));
	}
}
