package com.epam.jmp.bank.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.jmp.bank.dao.PersonDao;
import com.epam.jmp.bank.exceptions.PersonNotFoundException;
import com.epam.jmp.bank.model.Person;

@Component
public class PersonDaoImpl extends AbstractDao implements PersonDao {

	@Override
	public String getTableName() {
		return "Person";
	}
	
	@Override
	public List<Person> getAll() {
		return (List<Person>) getAllRows();
	}

	@Override
	public Long create(String firstName, String lastName) {
		Long id = generateId();
		Person person = new Person(id, firstName, lastName);

		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();

		return person.getId();
	}

	@Override
	public Person getById(Long id) {

		Person person = em.find(Person.class, id);

		if(person == null) {
			throw new PersonNotFoundException(id);
		}

		return person;
	}

}