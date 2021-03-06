package com.epam.jmp.bank;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.epam.jmp.bank.dao.AccountDaoTest;
import com.epam.jmp.bank.dao.BankDaoTest;
import com.epam.jmp.bank.dao.CurrencyDaoTest;
import com.epam.jmp.bank.dao.EmployeeDaoTest;
import com.epam.jmp.bank.dao.PersonDaoTest;
import com.epam.jmp.bank.services.*;
import com.epam.jmp.bank.springwebjaas.*;

@Ignore
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
