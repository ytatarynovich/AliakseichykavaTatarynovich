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

	private static final String FIRST_NAME = "firstname";
	private static final String LAST_NAME = "lastname";

	public PersonDao() {
		super();
	}

	@Override
	protected String getTableName() {
		return "person";
	}

	synchronized public Long persist(String firstName, String lastName) throws SQLException {
		Long id = generateId();

		PreparedStatement prStatement = prepareStatement("INSERT INTO Person(id, firstname, lastname) VALUES(?, ?, ?);");
		prStatement.setLong(1, id);
		prStatement.setString(2, firstName);
		prStatement.setString(3, lastName);
		execute(prStatement);
		return id;
	}

	private Person formPerson(Map<String, String> row) throws SQLException {
		return new Person(
				new Long(row.get(ID)),
				row.get(FIRST_NAME),
				row.get(LAST_NAME)
			);
	}

	public Person getPerson(Long id) throws SQLException {

		PreparedStatement prStatement = prepareStatement("SELECT * FROM " + getTableName() +" WHERE id=?;");
		prStatement.setLong(1, id);

		List<Map<String, String>> rows = readInfo(prStatement);
		if(rows.size() == 0) {
			throw new PersonNotFoundException(id);
		}
		Map<String, String> row = rows.get(0);
		return formPerson(row);
	}

	public List<Person> getAll() throws SQLException {
		List<Map<String, String>> rows = getAllRows();
		List<Person> persons = new ArrayList<Person>();
		for (Map<String, String> row : rows) {
			persons.add(formPerson(row));
		}
		return persons;
	}

}
