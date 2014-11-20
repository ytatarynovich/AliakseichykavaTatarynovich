package com.epam.jmp.bank.dao;

import java.sql.SQLException;

import org.dbunit.dataset.IDataSet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.epam.jmp.bank.exceptions.EmployeeNotFoundException;
import com.epam.jmp.bank.model.Employee;

/**
 * @author Hanna_Aliakseichykava
 */
@RunWith(value = BlockJUnit4ClassRunner.class)
public class EmployeeDaoTest extends DBUnitTestCase {
	
	private EmployeeDao dao = new EmployeeDao();

	@Override
	protected String getDataPath() {
		return "dao/employee-data.xml";
	}

	@Override
	protected String getTableName() {
		return "employee";
	}

	@Test
	public void testGetEmployeeByLogin() throws Exception {
		int rowNumber = 0;
		IDataSet actualData = getActualData();
		String login = actualData.getTable(getTableName()).getValue(rowNumber, "login").toString();
		long expectedId = new Long(actualData.getTable(getTableName()).getValue(rowNumber, "id").toString());

		Employee employee = dao.getEmployeeByLogin(login);
		Assert.assertEquals(expectedId, employee.getId());
	}

	@Test(expected = EmployeeNotFoundException.class)
	public void testGetEmployeeByLoginNotFound() throws SQLException {
		String nonExistentLogin = "NonExistent";
		dao.getEmployeeByLogin(nonExistentLogin);
	}

}
