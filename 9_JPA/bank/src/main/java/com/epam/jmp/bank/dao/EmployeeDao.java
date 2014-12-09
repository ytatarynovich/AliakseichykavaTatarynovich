package com.epam.jmp.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.epam.jmp.bank.exceptions.EmployeeNotFoundException;
import com.epam.jmp.bank.model.Employee;

/**
 * @author Hanna_Aliakseichykava
 */
public class EmployeeDao extends AbstractDao {

	@Override
	protected String getTableName() {
		return "Employee";
	}

	public Employee getEmployeeById(Long id) {

		Employee employee = em.find(Employee.class, id);

		if(employee == null) {
			throw new EmployeeNotFoundException(id);
		}

		return employee;
	}

	public Employee getEmployeeByLogin(String login) {

		List<Employee> employees = em.createNamedQuery("Employee.findByLogin", Employee.class)
				.setParameter("login", login)
				.getResultList();

		if(employees.size() == 0) {
			throw new EmployeeNotFoundException(login);
		}

		return employees.get(0);
	}

	public String getPasswordById(Long id) throws SQLException {

		return getEmployeeById(id).getPassword();
	}

}
