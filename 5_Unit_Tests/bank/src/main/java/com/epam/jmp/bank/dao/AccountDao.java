package com.epam.jmp.bank.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.epam.jmp.bank.exceptions.AccountNotFoundException;
import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.model.Person;

/**
 * @author Hanna_Aliakseichykava
 */
public class AccountDao extends AbstractDao {

	private static final Currency DEFAULT_CURRENCY = Currency.BY;

	private static final String PERSON_ID = "personid";
	private static final String CURRENCY_NAME = "currency";
	private static final String AMOUNT = "amount";

	private PersonDao personDao;

	public AccountDao() {
		this.personDao = new PersonDao();
	}

	public AccountDao(Properties props) {
		super(props);
		this.personDao = new PersonDao();
	}

	@Override
	protected String getTableName() {
		return "account";
	}

	public long persist(Long bankId, String firstName, String lastName) throws SQLException {

		Long personId = personDao.persist(firstName, lastName);

		Long id = generateId();
		PreparedStatement prStatement = prepareStatement("INSERT INTO Account(id, bankid, personid, currency, amount) VALUES(?, ?, ?, ?, ?);");
		prStatement.setLong(1, id);
		prStatement.setLong(2, bankId);
		prStatement.setLong(3, personId);
		prStatement.setString(4, DEFAULT_CURRENCY.name());
		prStatement.setDouble(5, 0);
		execute(prStatement);
		return id;
	}

	private Account formAccount(Map<String, String> row) throws SQLException {
		Person person = personDao.getPerson(new Long(row.get(PERSON_ID)));

		return new Account(
				new Long(row.get(ID)),
				person,
				Currency.findByName(row.get(CURRENCY_NAME)),
				new Double(row.get(AMOUNT))
			);
	}

	public Account getAccountById(long id) throws SQLException {

		PreparedStatement prStatement = prepareStatement("SELECT * FROM " + getTableName() +" WHERE id=?;");
		prStatement.setLong(1, id);
		List<Map<String, String>> rows = readInfo(prStatement);
		if(rows.size() == 0) {
			throw new AccountNotFoundException(id);
		}
		Map<String, String> row = rows.get(0);

		return formAccount(row);
	}

	public List<Account> formAccounts(PreparedStatement prStatement) throws SQLException {

		List<Map<String, String>> rows = readInfo(prStatement);
		List<Account> accounts = new ArrayList<Account>();

		for(Map<String, String> row : rows) {
			accounts.add(formAccount(row));
		}
		return accounts;
	}

	public List<Account> getAllAccounts(Long bankId) throws SQLException {

		PreparedStatement prStatement = prepareStatement("SELECT * FROM " + getTableName() +" WHERE bankid=?;");
		prStatement.setLong(1, bankId);

		return formAccounts(prStatement);
	}

	public List<Account> getAccountByFirstOrLastName(Long bankId, String name) throws SQLException {

		PreparedStatement prStatement = prepareStatement(
			"SELECT Account.* FROM Account " +
			"join Person on Account.personid = Person.id " +
			"WHERE bankid = ? AND " +
			"(Person.firstname = ? " +
			"OR Person.lastname = ?)");

		prStatement.setLong(1, bankId);
		prStatement.setString(2, name);
		prStatement.setString(3, name);

		return formAccounts(prStatement);
	}

}
