package com.epam.jmp.bank;

import java.util.Properties;

import org.dbunit.DBTestCase;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;

import com.epam.jmp.bank.dao.ConfigConst;
import com.epam.jmp.utils.PropertyUtils;

public class DBUnitTestCase extends DBTestCase implements ConfigConst {

	private Properties dbProps;

	protected IDataSet beforeData;

	protected IDatabaseTester tester;

	public DBUnitTestCase() {
		dbProps = PropertyUtils.loadProperties(CONFIG_PATH);

		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, dbProps.getProperty(DRIVER_PROP_NAME));
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, dbProps.getProperty(URL_PROP_NAME));
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, dbProps.getProperty(USER_PROP_NAME));
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, dbProps.getProperty(PASSWORD_PROP_NAME));
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, dbProps.getProperty(SCHEMA_PROP_NAME));
	}

	@Before
	public void setUp() throws Exception {
		tester = new JdbcDatabaseTester(
				dbProps.getProperty(DRIVER_PROP_NAME),
				dbProps.getProperty(URL_PROP_NAME),
				dbProps.getProperty(USER_PROP_NAME),
				dbProps.getProperty(PASSWORD_PROP_NAME));
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return beforeData;
	}

	@Override
	protected DatabaseOperation getTearDownOperation() throws Exception {
		return DatabaseOperation.DELETE_ALL;
	}
}
