package com.epam.jmp.bank.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.epam.jmp.bank.exceptions.PersonNotFoundException;
import com.epam.jmp.bank.model.Person;

/**
 * @author Hanna_Aliakseichykava
 */
public class PersonDao extends AbstractDao {

	public PersonDao() {
		super();
	}

	@Override
	protected String getTableName() {
		return "Person";
	}

	synchronized public Long persist(String firstName, String lastName) throws SQLException {
		Long id = generateId();
		Person person = new Person(id, firstName, lastName);

		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		em.close();

		return person.getId();
	}

	public Person getPerson(Long id) throws SQLException {

		Person person = em.find(Person.class, id);

		if(person == null) {
			throw new PersonNotFoundException(id);
		}

		return person;
	}

}
