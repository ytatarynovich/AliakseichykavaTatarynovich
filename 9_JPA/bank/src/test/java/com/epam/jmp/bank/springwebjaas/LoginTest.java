package com.epam.jmp.bank.springwebjaas;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.epam.jmp.bank.model.Employee;
import com.epam.jmp.bank.model.Role;
import com.epam.jmp.bank.services.EmployeeService;

import static com.googlecode.catchexception.CatchException.*;

/**
 * @author Hanna_Aliakseichykava
 */
public class LoginTest {

	Login loginHelper;

	private static final String PASSWORD_2 = "o6DE6RZmdcUY3h/Tym2/NA=="; // Pass2
	private static final String PASSWORD_3 = "KB2CR5IxCNL+Qk9DQK9n9A=="; // Pass3

	@Before
	public void setUp() {

		EmployeeService service = Mockito.mock(EmployeeService.class);

		Employee employee1 = new Employee(1L, "Login1", "", "", Role.ADMIN);
		Employee employee2 = new Employee(2L, "Login2", "", "", Role.ADMIN);
		Employee employee3 = new Employee(3L, "Login3", "", "", Role.ACCOUNTANT);

		when(service.getEmployeeByLogin("NotExist")).thenReturn(null);
		when(service.getEmployeeByLogin("Login1")).thenReturn(employee1);
		when(service.getEmployeeByLogin("Login2")).thenReturn(employee2);
		when(service.getEmployeeByLogin("Login3")).thenReturn(employee3);

		when(service.getPasswordById(1L)).thenReturn(null);
		when(service.getPasswordById(2L)).thenReturn(PASSWORD_2);
		when(service.getPasswordById(3L)).thenReturn(PASSWORD_3);

		loginHelper = new Login();
		loginHelper.setService(service);
		loginHelper.setSubject(new Subject());
	}

	@Test
	public void testLoginNullUserName() throws LoginException {
		loginHelper.setInputCredentials(null, "Temp");
		catchException(loginHelper).login();
		assertTrue(caughtException() instanceof LoginException);
		assertEquals("User is not valid", caughtException().getMessage());
	}

	@Test
	public void testLoginNullPassword() throws LoginException {
		loginHelper.setInputCredentials("Temp", null);
		catchException(loginHelper).login();
		assertTrue(caughtException() instanceof LoginException);
		assertEquals("User is not valid", caughtException().getMessage());
	}

	@Test
	public void testLoginNonExistentLogin() throws LoginException {
		String nonExistentLogin = "NotExist";
		loginHelper.setInputCredentials(nonExistentLogin, "Temp");
		catchException(loginHelper).login();
		assertTrue(caughtException() instanceof LoginException);
		assertEquals("User is not valid", caughtException().getMessage());
	}

	@Test
	public void testLoginEmployeeWithDamagedPassword() throws LoginException {
		loginHelper.setInputCredentials("Login1", "Temp");
		catchException(loginHelper).login();
		assertTrue(caughtException() instanceof LoginException);
		assertEquals("Actual user password is damaged", caughtException().getMessage());
	}

	@Test
	public void testLoginInvalidPassword() throws LoginException {
		loginHelper.setInputCredentials("Login2", "Pass1");
		catchException(loginHelper).login();
		assertTrue(caughtException() instanceof LoginException);
		assertEquals("Password is not valid", caughtException().getMessage());
	}

	@Test
	public void testLoginAdmin() throws LoginException {

		loginHelper.setInputCredentials("Login2", "Pass2");
		loginHelper.login();
		String role = loginHelper.getSubject().getPrincipals().iterator().next().getName();
		Assert.assertThat(role, equalTo(Role.ADMIN.name()));
	}

	@Test
	public void testLoginAccountant() throws LoginException {
		loginHelper.setInputCredentials("Login3", "Pass3");
		loginHelper.login();
		String role = loginHelper.getSubject().getPrincipals().iterator().next().getName();
		Assert.assertThat(role, equalTo(Role.ACCOUNTANT.name()));
	}

}
