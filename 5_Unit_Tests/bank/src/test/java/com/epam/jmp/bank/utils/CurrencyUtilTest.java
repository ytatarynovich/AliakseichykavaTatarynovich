package com.epam.jmp.bank.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.api.mockito.PowerMockito;
import com.epam.jmp.bank.model.Currency;

import static org.mockito.Mockito.*;

import static org.hamcrest.Matchers.*;

/**
 * @author Hanna_Aliakseichykava
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ Currency.class })
public class CurrencyUtilTest {

	Currency currencyFrom;
	Currency currencyTo;

	private static final double FROM_TO_EXCHANGE_RATE = 2D;

	@Before
	public void setUp() {
		currencyFrom = PowerMockito.mock(Currency.class);
		currencyTo = PowerMockito.mock(Currency.class);

		when(currencyFrom.getExchangeCoeff(currencyTo)).thenReturn(FROM_TO_EXCHANGE_RATE);
	}

	@Test
	public void testExchangeCurrency() {
		double amount = 5000;
		double exchangedAmount = CurrencyUtil.exchangeCurrency(amount, currencyFrom, currencyTo);
		Assert.assertThat(exchangedAmount, is(equalTo(amount * FROM_TO_EXCHANGE_RATE)));
	}

}
