package com.epam.jmp.bank.services;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.model.CurrencyRate;

/**
 * @author Hanna_Aliakseichykava
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ Currency.class })
public class CurrencyServiceImplTest {

	private static final String EXPECTED_JSON = "[{\"rate\":\"1.0\",\"name\":\"BY\"},{\"rate\":\"5.0\",\"name\":\"USD\"}]";

	CurrencyService service = new CurrencyServiceImpl();

	@Before
	public void setUp() {
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
		Assert.assertThat(exchangedAmount, is(equalTo(amount * exchangeRate)));
	}
}
