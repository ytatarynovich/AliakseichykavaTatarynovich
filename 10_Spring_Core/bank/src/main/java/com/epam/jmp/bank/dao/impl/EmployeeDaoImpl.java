package com.epam.jmp.bank.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.jmp.bank.dao.EmployeeDao;
import com.epam.jmp.bank.exceptions.EmployeeNotFoundException;
import com.epam.jmp.bank.model.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {

	@Override
	public String getTableName() {
		return "Employee";
	}

	@Override
	public Employee getById(Long id) {

		Employee employee = getEntityManager().find(Employee.class, id);

		if(employee == null) {
			throw new EmployeeNotFoundException(id);
		}

		return employee;
	}

	@Override
	public Employee getByLogin(String login) {

		List<Employee> employees = getEntityManager().createNamedQuery("Employee.findByLogin", Employee.class)
				.setParameter("login", login)
				.getResultList();

		if(employees.size() == 0) {
			throw new EmployeeNotFoundException(login);
		}

		return employees.get(0);
	}

	@Override
	public String getPasswordById(Long id) {

		return getById(id).getPassword();
	}

}
