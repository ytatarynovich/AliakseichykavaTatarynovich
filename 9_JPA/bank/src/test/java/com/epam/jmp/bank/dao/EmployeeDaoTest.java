package com.epam.jmp.bank.dao;

import java.sql.SQLException;

import org.dbunit.dataset.IDataSet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.jmp.bank.exceptions.EmployeeNotFoundException;
import com.epam.jmp.bank.model.Employee;

/**
 * @author Hanna_Aliakseichykava
 */
@RunWith(value = BlockJUnit4ClassRunner.class)
public class EmployeeDaoTest extends DBUnitTestCase {

	@Autowired
	private EmployeeDao dao;

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

		Employee employee = dao.getByLogin(login);
		Assert.assertEquals(expectedId, employee.getId());
	}

	@Test(expected = EmployeeNotFoundException.class)
	public void testGetEmployeeByLoginNotFound() throws SQLException {
		String nonExistentLogin = "NonExistent";
		dao.getByLogin(nonExistentLogin);
	}

	@Test
	public void testGetPasswordById() throws Exception {
		Long id = 1L;
		String expectedPass = "123";

		String pass = dao.getPasswordById(id);
		Assert.assertEquals(expectedPass, pass);
	}

	@Test(expected = EmployeeNotFoundException.class)
	public void testGetPasswordByIdNotFoundEmployee() throws SQLException {
		Long nonExistentId = 123L;
		dao.getPasswordById(nonExistentId);
	}

	@Test(expected = EmployeeNotFoundException.class)
	public void testGetEmployeeByNullLogin() throws SQLException {
		String nonExistentLogin = null;
		dao.getByLogin(nonExistentLogin);
	}

}
