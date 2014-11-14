package com.epam.jmp.bank.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.epam.jmp.bank.exceptions.AccountNotFoundException;
import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.model.Person;
import com.google.common.annotations.VisibleForTesting;

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

	private Account formAccount(Map<String, String> row) {

		try {
			Person person = personDao.getPerson(new Long(row.get(PERSON_ID)));

			return new Account(
					new Long(row.get(ID)),
					person,
					Currency.findByName(row.get(CURRENCY_NAME)),
					new Double(row.get(AMOUNT))
				);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Account getAccountById(long id) {

		PreparedStatement prStatement = prepareStatement("SELECT * FROM " + getTableName() +" WHERE id=?;");

		try {
			prStatement.setLong(1, id);
			List<Map<String, String>> rows = readInfo(prStatement);
			if(rows.size() == 0) {
				throw new AccountNotFoundException(id);
			}
			Map<String, String> row = rows.get(0);

			return formAccount(row);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Account> formAccounts(PreparedStatement prStatement) {

		List<Map<String, String>> rows = readInfo(prStatement);
		List<Account> accounts = new ArrayList<Account>();

		for(Map<String, String> row : rows) {
			accounts.add(formAccount(row));
		}
		return accounts;
	}

	public List<Account> getAllAccounts(Long bankId) {

		PreparedStatement prStatement = prepareStatement("SELECT * FROM " + getTableName() +" WHERE bankid=?;");

		try {
			prStatement.setLong(1, bankId);
			return formAccounts(prStatement);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
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

	public void update(Account account) throws SQLException {
		PreparedStatement prStatement = prepareStatement("UPDATE Account SET currency=?, amount=? WHERE id=?;");
		prStatement.setString(1, account.getAccountCurrency().name());
		prStatement.setDouble(2, account.getAmount());
		prStatement.setLong(3, account.getId());
		execute(prStatement);
		//TODO: update Person
	}

	@VisibleForTesting
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

}
