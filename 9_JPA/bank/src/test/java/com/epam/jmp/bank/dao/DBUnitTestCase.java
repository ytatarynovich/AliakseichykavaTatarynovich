package com.epam.jmp.bank.dao;

import java.util.Properties;

import org.dbunit.DBTestCase;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;

import com.epam.jmp.utils.PropertyUtils;

public abstract class DBUnitTestCase extends DBTestCase {
	
	public static final String CONFIG_PATH = "db.properties";

	public static final String DRIVER_PROP_NAME = "db.driver";
	public static final String URL_PROP_NAME = "db.url";
	public static final String USER_PROP_NAME = "db.username";
	public static final String PASSWORD_PROP_NAME = "db.password";
	public static final String SCHEMA_PROP_NAME = "db.schema";

	protected Properties dbProps;

	protected IDataSet beforeData;

	protected IDatabaseTester tester;

	protected abstract String getDataPath();

	protected abstract String getTableName();

	public DBUnitTestCase() {
		dbProps = PropertyUtils.loadFromResources(CONFIG_PATH);

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

		beforeData = loadDataSet(getDataPath());
 
		tester.setDataSet(beforeData);
		tester.onSetup();
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return beforeData;
	}

	@Override
	protected DatabaseOperation getTearDownOperation() throws Exception {
		return DatabaseOperation.DELETE_ALL;
	}

	protected IDataSet getActualData() throws Exception {
		return tester.getConnection().createDataSet();
	}

	protected IDataSet loadDataSet(String path) throws Exception {
		return new FlatXmlDataSetBuilder().build(
			Thread.currentThread().getContextClassLoader()
			.getResourceAsStream(path));
	}

}
