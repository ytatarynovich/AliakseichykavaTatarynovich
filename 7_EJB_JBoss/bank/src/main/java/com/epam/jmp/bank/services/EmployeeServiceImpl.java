package com.epam.jmp.bank.services;

import java.sql.SQLException;

import com.epam.jmp.bank.dao.EmployeeDao;
import com.epam.jmp.bank.model.Employee;

/**
 * @author Hanna_Aliakseichykava
 */
public class EmployeeServiceImpl implements EmployeeService {

	private static final long serialVersionUID = 2L;
	private EmployeeDao employeeDao;

	public EmployeeServiceImpl() {
		this.employeeDao = new EmployeeDao();
	}

	@Override
	public Employee getEmployeeByLogin(String login) {
		try {
			return employeeDao.getEmployeeByLogin(login);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
