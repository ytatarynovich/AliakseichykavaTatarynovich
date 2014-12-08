package com.epam.jmp.bank.services;

import java.io.Serializable;

import javax.ejb.Local;

import com.epam.jmp.bank.model.Employee;

/**
 * @author Hanna_Aliakseichykava
 */
@Local
public interface EmployeeService extends Serializable {

	public Employee getEmployeeByLogin(String login);

	public String getPasswordById(Long id);

}
