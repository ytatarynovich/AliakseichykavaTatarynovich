package com.epam.jmp.bank.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.epam.jmp.bank.services.*;
import com.epam.jmp.bank.springwebjaas.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AccountDaoTest.class,
	BankDaoTest.class,
	CurrencyDaoTest.class,
	EmployeeDaoTest.class,
	PersonDaoTest.class,

	LoginTest.class,
	LoginInitTest.class,

	AccountServiceImplTest.class,
	BankServiceImplTest.class,
	CurrencyServiceImplTest.class
})
public class TestSuite {

}
