package com.epam.jmp.bank.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jmp.bank.dao.PersonDao;
import com.epam.jmp.bank.exceptions.PersonNotFoundException;
import com.epam.jmp.bank.model.Person;

@Repository
public class PersonDaoImpl extends AbstractDao implements PersonDao {

	@Override
	public String getTableName() {
		return "Person";
	}

	@Override
	public List getAll() {
		return getAllRows();
	}

	@Override
	@Transactional
	public Long create(String firstName, String lastName) {

		Person person = new Person(firstName, lastName);
		getEntityManager().persist(person);
		getEntityManager().flush();
		return person.getId();
	}

	@Override
	public Person getById(Long id) {

		Person person = getEntityManager().find(Person.class, id);

		if(person == null) {
			throw new PersonNotFoundException(id);
		}

		return person;
	}

}