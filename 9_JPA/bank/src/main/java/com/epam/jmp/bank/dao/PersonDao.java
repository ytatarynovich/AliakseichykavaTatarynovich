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

	//private static final String FIRST_NAME = "firstname";
	//private static final String LAST_NAME = "lastname";

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
		em.persist(person);
		return person.getId();
	}

	/*private Person formPerson(Map<String, String> row) throws SQLException {
		return new Person(
				new Long(row.get(ID)),
				row.get(FIRST_NAME),
				row.get(LAST_NAME)
			);
	}*/

	public Person getPerson(Long id) throws SQLException {

		return em.find(Person.class,  id);
	}

	/*public List<Person> getAll() throws SQLException {
		List<Map<String, String>> rows = getAllRows();
		List<Person> persons = new ArrayList<Person>();
		for (Map<String, String> row : rows) {
			persons.add(formPerson(row));
		}
		return persons;
	}*/

}
