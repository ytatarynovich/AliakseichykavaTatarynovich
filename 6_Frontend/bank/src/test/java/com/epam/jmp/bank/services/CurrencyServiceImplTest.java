package com.epam.jmp.bank.services;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.epam.jmp.bank.model.Currency;

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

		Currency currency1 = PowerMockito.mock(Currency.class);
		when(currency1.getName()).thenReturn("BY");
		when(currency1.getRate()).thenReturn(1D);

		Currency currency2 = PowerMockito.mock(Currency.class);
		when(currency2.getName()).thenReturn("USD");
		when(currency2.getRate()).thenReturn(5D);

		PowerMockito.mockStatic(Currency.class);
		when(Currency.values()).thenReturn(new Currency[] {currency1, currency2});
	}

	@Test
	public void testGetAllCurrenciesAsJson() {

		Assert.assertThat(service.getAllCurrenciesAsJson(), equalTo(EXPECTED_JSON));
	}
}
