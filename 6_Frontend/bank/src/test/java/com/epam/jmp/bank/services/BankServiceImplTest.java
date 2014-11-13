package com.epam.jmp.bank.services;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.epam.jmp.bank.dao.BankDao;
import com.epam.jmp.bank.model.Bank;

/**
 * @author Hanna_Aliakseichykava
 */
public class BankServiceImplTest {

	private static final String EXPECTED_JSON = "[{\"id\":\"1\",\"name\":\"Bank11\"},{\"id\":\"2\",\"name\":\"Bank21\"}]";

	BankServiceImpl service = new BankServiceImpl();

	@Before
	public void setUp() {

		Bank bank1 = new Bank(1L, "Bank11");
		Bank bank2 = new Bank(2L, "Bank21");

		BankDao dao = Mockito.mock(BankDao.class);
		when(dao.getAll()).thenReturn(Arrays.asList(new Bank[] {bank1, bank2}));

		service.setDao(dao);
	}

	@Test
	public void testGetAllBanksAsJson() {

		Assert.assertThat(service.getAllBanksAsJson(), equalTo(EXPECTED_JSON));
	}

}
