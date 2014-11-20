package com.epam.jmp.bank.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.epam.jmp.bank.exceptions.EmployeeNotFoundException;
import com.epam.jmp.bank.model.Employee;
import com.epam.jmp.bank.model.Role;

/**
 * @author Hanna_Aliakseichykava
 */
public class EmployeeDao extends AbstractDao {

	private static final String FIRST_NAME = "firstname";
	private static final String LAST_NAME = "lastname";
	private static final String LOGIN = "login";
	private static final String ROLE = "role";

	@Override
	protected String getTableName() {
		return "employee";
	}

	public Employee getEmployeeByLogin(String login) throws SQLException {

		PreparedStatement prStatement = prepareStatement("SELECT * FROM " + getTableName() +" WHERE login=?;");
		prStatement.setString(1, login);

		List<Map<String, String>> rows = readInfo(prStatement);
		if(rows.size() == 0) {
			throw new EmployeeNotFoundException(login);
		}
		Map<String, String> row = rows.get(0);
		return formEmployee(row);
	}

	private Employee formEmployee(Map<String, String> row) {
		return new Employee(
				new Long(row.get(ID)),
				row.get(LOGIN),
				row.get(FIRST_NAME),
				row.get(LAST_NAME),
				Role.findByName(row.get(ROLE))
			);
	}

}
