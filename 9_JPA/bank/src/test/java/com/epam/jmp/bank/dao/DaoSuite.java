package com.epam.jmp.bank.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	AccountDaoTest.class,
	BankDaoTest.class,
	CurrencyDaoTest.class,
	EmployeeDaoTest.class,
	PersonDaoTest.class
})
public class DaoSuite {

}
