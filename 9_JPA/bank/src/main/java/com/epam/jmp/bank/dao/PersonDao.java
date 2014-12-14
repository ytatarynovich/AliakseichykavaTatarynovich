package com.epam.jmp.bank.dao;

import java.util.List;

import com.epam.jmp.bank.model.Person;

/**
 * @author Hanna_Aliakseichykava
 */
public interface PersonDao {

	public Long create(String firstName, String lastName);

	public Person getById(Long id);
	
	public List<Person> getAll();
}
