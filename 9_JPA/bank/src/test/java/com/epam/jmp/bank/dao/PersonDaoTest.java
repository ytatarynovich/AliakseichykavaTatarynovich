package com.epam.jmp.bank.dao;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.jmp.bank.model.Person;
import com.epam.jmp.bank.exceptions.PersonNotFoundException;

/**
 * @author Hanna_Aliakseichykava
 */
public class PersonDaoTest extends DBUnitTestCase {

	private PersonDao dao;

	@Before
	public void setUp() throws Exception {
		dao = applicationContext.getBean(PersonDao.class);
	}

	@Override
	protected String getDataPath() {
		return "dao/person-data.xml";
	}

	@Override
	protected String getTableName() {
		return "person";
	}

	@Test
	public void testGetAll() throws Exception {
		List<Person> persons = dao.getAll();

		IDataSet expectedData = loadDataSet(getDataPath());

		IDataSet actualData = getActualData();

		Assertion.assertEquals(expectedData.getTable(getTableName()), actualData.getTable(getTableName()));
		Assert.assertEquals(expectedData.getTable(getTableName()).getRowCount(), actualData.getTable(getTableName()).getRowCount());
		Assert.assertEquals(expectedData.getTable(getTableName()).getRowCount(), persons.size());
	}

	@Test
	public void testGetPerson() throws Exception {
		long id = 1;
		Person person = dao.getById(id);
		Assert.assertEquals(id, person.getId());
	}

	@Test(expected = PersonNotFoundException.class)
	public void testGetPersonNotFound() throws SQLException {
		long nonExistentId = 10;
		dao.getById(nonExistentId);
	}

	private static final String TEST_FIRST_NAME = "Ann";
	private static final String TEST_LAST_NAME = "Aleks";

	@Test
	public void testPersist() throws Exception {
		int initialPersonsCount = dao.getAll().size();

		dao.create(TEST_FIRST_NAME, TEST_LAST_NAME);

		IDataSet expectedData = loadDataSet("dao/person-data-save.xml");
 
		IDataSet actualData = getActualData();

		String[] ignore = {"id"};
		Assertion.assertEqualsIgnoreCols(expectedData, actualData, getTableName(), ignore);
		Assert.assertEquals(expectedData.getTable(getTableName()).getRowCount(), initialPersonsCount + 1);
	}

}
