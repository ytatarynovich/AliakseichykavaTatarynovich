package com.epam.jmp.bank.springwebjaas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Hanna_Aliakseichykava
 */
public class LoginInitTest {

	Login loginHelper;

	@Before
	public void setUp() {
		loginHelper = new Login();
	}

	@Test
	public void testLoginNotNullService() {
		assertNotNull(loginHelper.getService());
	}
}
