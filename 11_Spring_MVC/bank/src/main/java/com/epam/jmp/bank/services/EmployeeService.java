package com.epam.jmp.bank.services;

import com.epam.jmp.bank.model.Employee;

/**
 * @author Hanna_Aliakseichykava
 */
public interface EmployeeService {

	public Employee getEmployeeByLogin(String login);

	public String getPasswordById(Long id);

}
