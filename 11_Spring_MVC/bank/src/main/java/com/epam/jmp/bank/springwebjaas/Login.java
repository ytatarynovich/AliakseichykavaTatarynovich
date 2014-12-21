package com.epam.jmp.bank.springwebjaas;

import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.epam.jmp.bank.model.Employee;
import com.epam.jmp.bank.services.EmployeeService;
import com.google.common.annotations.VisibleForTesting;

/**
 * @see http://techannotation.wordpress.com/2012/12/05/5-minutes-with-spring-authentication-and-authorization-service-jaa/
 */
@Component
public class Login implements LoginModule, ApplicationContextAware {

	private String password;
	private String username;
	private Subject subject;

	private static EmployeeService service;

	protected static final Logger log = Logger.getLogger(Login.class);

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		setService(context.getBean(EmployeeService.class));
		log.info("\n\n!!! Service is initialized\n\n");
	} 

	@Override
	public boolean login() throws LoginException {

		Employee employee = getService().getEmployeeByLogin(username);

		if (username == null || password == null || employee == null) {
			throw new LoginException("User is not valid");
		}

		String passwordDecrypted = EncodeDecode.encrypt(password);
		String actualPassword = getService().getPasswordById(employee.getId());

		if(actualPassword == null) {
			throw new LoginException("Actual user password is damaged");
		}

		if(passwordDecrypted.equals(actualPassword)) {
			subject.getPrincipals().add(new UserPrincipal(employee.getRole()));
			return true;
		} else {
			throw new LoginException("Password is not valid");
		}
	}

	@Override
	public boolean abort() throws LoginException {
		return false;
	}

	@Override
	public boolean commit() throws LoginException {
		return true;
	}

	@Override
	public boolean logout() throws LoginException {
		log.info("\n\n!! Jaas Logout\n\n");
		System.out.println("\n\n!! Jaas Logout\n\n");
		//subject.getPrincipals().clear();
		return true;
	}

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler,
			Map<String, ?> state, Map<String, ?> options) {
		this.subject = subject;

		try {
			NameCallback nameCallback = new NameCallback("prompt");
			PasswordCallback passwordCallback = new PasswordCallback("prompt", false);

			callbackHandler.handle(new Callback[] { nameCallback,
					passwordCallback });

			password = new String(passwordCallback.getPassword());
			username = nameCallback.getName();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	public EmployeeService getService() {
		return service;
	}

	public void setService(EmployeeService _service) {
		service = _service;
	}

	@VisibleForTesting
	public void setInputCredentials(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@VisibleForTesting
	public Subject getSubject() {
		return subject;
	}

	@VisibleForTesting
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
