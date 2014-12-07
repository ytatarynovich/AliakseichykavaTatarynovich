package com.epam.jmp.bank.dao;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.epam.jmp.bank.model.Person;
import com.epam.jmp.bank.exceptions.PersonNotFoundException;

/**
 * @author Hanna_Aliakseichykava
 */
@RunWith(value = BlockJUnit4ClassRunner.class)
public class PersonDaoTest extends DBUnitTestCase {

	private PersonDao dao = new PersonDao();

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
		List<Person> persons = dao.getAllRows();

		IDataSet expectedData = loadDataSet(getDataPath());

		IDataSet actualData = getActualData();

		Assertion.assertEquals(expectedData.getTable(getTableName()), actualData.getTable(getTableName()));
		Assert.assertEquals(expectedData.getTable(getTableName()).getRowCount(), persons.size());
	}

	private static final String TEST_FIRST_NAME = "Ann";
	private static final String TEST_LAST_NAME = "Aleks";

	@Test
	public void testPersist() throws Exception {
		int initialPersonsCount = dao.getAllRows().size();

		dao.persist(TEST_FIRST_NAME, TEST_LAST_NAME);

		IDataSet expectedData = loadDataSet("dao/person-data-save.xml");
 
		IDataSet actualData = getActualData();

		String[] ignore = {"id"};
		Assertion.assertEqualsIgnoreCols(expectedData, actualData, getTableName(), ignore);
		Assert.assertEquals(expectedData.getTable(getTableName()).getRowCount(), initialPersonsCount + 1);
 	}

	@Test
	public void testGetPerson() throws Exception {
		int rowNumber = 0;
		IDataSet actualData = getActualData();
		long id = new Long(actualData.getTable(getTableName()).getValue(rowNumber, "id").toString());
		String expectedFirstName = actualData.getTable(getTableName()).getValue(rowNumber, "firstname").toString();
		String expecedLastName = actualData.getTable(getTableName()).getValue(rowNumber, "lastname").toString();

		Person person = dao.getPerson(id);
		Assert.assertEquals(id, person.getId());
		Assert.assertEquals(expectedFirstName, person.getFirstName());
		Assert.assertEquals(expecedLastName, person.getLastName());
	}

	@Test(expected = PersonNotFoundException.class)
	public void testGetPersonNotFound() throws SQLException {
		long nonExistentId = 10;
		dao.getPerson(nonExistentId);
	}

}
