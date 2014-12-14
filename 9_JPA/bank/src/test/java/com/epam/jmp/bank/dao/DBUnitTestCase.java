package com.epam.jmp.bank.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.HibernateException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.hibernate.internal.SessionImpl;

/**
 * @author Hanna_Aliakseichykava
 */
@RunWith(value = BlockJUnit4ClassRunner.class)
public abstract class DBUnitTestCase {

	protected static final Logger log = Logger.getLogger(DBUnitTestCase.class);

	protected static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/test-db-context.xml");

	protected IDataSet beforeData;

	protected abstract String getDataPath();

	protected abstract String getTableName();

	private static IDatabaseConnection connection;

	@BeforeClass
	public static void initEntityManager() throws HibernateException, DatabaseUnitException {
		EntityManagerFactory emf = applicationContext.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();
		connection = new DatabaseConnection(((SessionImpl) (em.getDelegate())).connection());
	}

	@AfterClass
	public static void closeEntityManager() {
		//em.close();
		//emf.close();
	}

	@Before
	public void initDB() throws Exception {
		IDataSet dataSet = loadDataSet(getDataPath());
		DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
	}

	protected IDataSet getActualData() throws Exception {
		return connection.createDataSet();
	}

	protected IDataSet loadDataSet(String path) throws Exception {
		return new FlatXmlDataSetBuilder().build(
			Thread.currentThread().getContextClassLoader()
			.getResourceAsStream(path));
	}
}
