package com.epam.jmp.bank.dao;

import com.epam.jmp.bank.model.Employee;

/**
 * @author Hanna_Aliakseichykava
 */
public interface EmployeeDao {

	public Employee getById(Long id);

	public Employee getByLogin(String login);

	public String getPasswordById(Long id);
}
