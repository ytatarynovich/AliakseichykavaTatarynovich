package com.epam.jmp.bank.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	AccountDaoTest.class,
	BankDaoTest.class,
	CurrencyDaoTest.class,
	EmployeeDaoTest.class,
	PersonDaoTest.class,

	com.epam.jmp.bank.springwebjaas.LoginTest.class,
	com.epam.jmp.bank.springwebjaas.LoginInitTest.class
})
public class TestSuite {

}
