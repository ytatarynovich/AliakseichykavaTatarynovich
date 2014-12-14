package com.epam.jmp.bank.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.jmp.bank.dao.EmployeeDao;
import com.epam.jmp.bank.exceptions.EmployeeNotFoundException;
import com.epam.jmp.bank.model.Employee;
import com.epam.jmp.bank.services.EmployeeService;

/**
 * @author Hanna_Aliakseichykava
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee getEmployeeByLogin(String login) {
		try {
			return employeeDao.getByLogin(login);
		} catch(EmployeeNotFoundException e) {
			return null;
		}
	}

	@Override
	public String getPasswordById(Long id) {
		try {
			return employeeDao.getPasswordById(id);
		} catch(EmployeeNotFoundException e) {
			return null;
		}
	}

}
