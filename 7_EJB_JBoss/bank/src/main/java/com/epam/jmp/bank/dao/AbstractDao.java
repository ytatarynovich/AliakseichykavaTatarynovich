package com.epam.jmp.bank.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.epam.jmp.utils.PropertyUtils;

/**
 * @author Hanna_Aliakseichykava
 */
public abstract class AbstractDao implements ConfigConst, Serializable {

	private static final long serialVersionUID = 1L;

	protected static final String ID = "id";

	protected static final Logger log = Logger.getLogger(AbstractDao.class);

	private Connection connection;

	public AbstractDao() {
		Properties props = PropertyUtils.loadFromResources(CONFIG_PATH);
		connection = createConnection(props);
	}

	protected abstract String getTableName();

	private Connection createConnection(Properties props) {

		String driverName = props.getProperty(DRIVER_PROP_NAME);
		String databaseURL = props.getProperty(URL_PROP_NAME);

		try {
			Class.forName(driverName);
			log.info("Driver [" + driverName + "] is loaded");
		} catch (ClassNotFoundException e) {
			log.warn("Driver [" + driverName + "is not found");
		}

		Connection c = null;
		try {
			c = DriverManager.getConnection(databaseURL);
			log.info("Connection is established");
		} catch (SQLException e) {
			log.warn("SQLException " + e.getMessage());
		}

		return c;
	}

	private List<String> getColumns(ResultSet rs) throws SQLException{

		ResultSetMetaData metaData = rs.getMetaData();
		List<String> columns = new ArrayList<String>();

		for(int i = 1; i <= metaData.getColumnCount(); i++) {
			columns.add(metaData.getColumnName(i));
		}

		return columns;
	}

	protected List<Map<String, String>> readInfo(PreparedStatement prStatement) {

		ResultSet rs = null;

		List<Map<String, String>> rows = new ArrayList<Map<String, String>>();

		try {

			rs = prStatement.executeQuery();
			List<String> columns = getColumns(rs);

			while (rs.next()) {

				Map<String, String> row = new HashMap<String, String>();

				for(String column : columns) {

					row.put(column, rs.getString(column));
				}
				rows.add(row);
			}

		} catch (SQLException e) {

			log.warn(e.getMessage());

		} finally {

			try {
				if (rs != null)
					rs.close();

			} catch (SQLException e) {
				log.warn(e.getMessage());
			}

			try {
				if (prStatement != null)
					prStatement.close();
				
			} catch (SQLException e) {
				log.warn(e.getMessage());
			}
		}

		return rows;
	}

	protected void execute(PreparedStatement prStatement) {
		try {

			prStatement.execute();

		} catch (SQLException e) {

			log.warn(e.getMessage());
			throw new RuntimeException(e);

		} finally {

			try {
				if (prStatement != null)
					prStatement.close();
				
			} catch (SQLException e) {
				log.warn(e.getMessage());
			}
		}
	}

	protected PreparedStatement prepareStatement(String str) {
		try {
			return connection.prepareStatement(str);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	protected List<Map<String, String>> getAllRows() {
		PreparedStatement prStatement = prepareStatement("SELECT * FROM " + getTableName() +";");
		return readInfo(prStatement);
	}

	synchronized protected Long generateId() {
		return new Long(getAllRows().size() + 1);
	}

}
