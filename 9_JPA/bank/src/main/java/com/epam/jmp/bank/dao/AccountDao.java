package com.epam.jmp.bank.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

import com.epam.jmp.bank.exceptions.AccountNotFoundException;
import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.model.CurrencyRate;
import com.epam.jmp.bank.model.Person;
import com.google.common.annotations.VisibleForTesting;

/**
 * @author Hanna_Aliakseichykava
 */
@NamedQueries({
@NamedQuery(
	name="Account.findByBankId", 
	query="select a from Account where a.bank.id = :bankId"),
@NamedQuery(
	name="Account.findByByFirstOrLastName", 
	query="select a from Account where a.bank.id = :bankId AND (a.person.firstName = :name OR a.person.lastName = :name)"),
@NamedQuery(
	name = "Account.updateCurrencyAmount",
	query = "UPDATE Account SET currency = :currency, amount = :amount WHERE id = :id;")
})
public class AccountDao extends AbstractDao {

	private static final Currency DEFAULT_CURRENCY = Currency.BY;
	private static final double DEFAULT_AMOUNT = 0;

	//private static final String PERSON_ID = "personid";
	//private static final String CURRENCY_NAME = "currency";
	//private static final String AMOUNT = "amount";

	private PersonDao personDao;

	public AccountDao() {
		this.personDao = new PersonDao();
	}

	@Override
	protected String getTableName() {
		return "Account";
	}

	public long persist(Long bankId, String firstName, String lastName) throws SQLException {

		Long personId = personDao.persist(firstName, lastName);
		Person person = personDao.getPerson(personId);

		Long id = generateId();
		
		/*PreparedStatement prStatement = prepareStatement("INSERT INTO Account(id, bankid, personid, currency, amount) VALUES(?, ?, ?, ?, ?);");
		prStatement.setLong(1, id);
		prStatement.setLong(2, bankId);
		prStatement.setLong(3, personId);
		prStatement.setString(4, DEFAULT_CURRENCY.name());
		prStatement.setDouble(5, 0);
		execute(prStatement);
		return id;*/
		
		Account account = new Account(id, person, DEFAULT_CURRENCY, DEFAULT_AMOUNT);

		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();
		em.close();
		
		return account.getId();
	}

	/*private Account formAccount(Map<String, String> row) {

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
	}*/

	public Account getAccountById(long id) {

		/*PreparedStatement prStatement = prepareStatement("SELECT * FROM " + getTableName() +" WHERE id=?;");

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
		}*/
		
		return em.find(Account.class,  id);
	}

	/*public List<Account> formAccounts(PreparedStatement prStatement) {

		List<Map<String, String>> rows = readInfo(prStatement);
		List<Account> accounts = new ArrayList<Account>();

		for(Map<String, String> row : rows) {
			accounts.add(formAccount(row));
		}
		return accounts;
	}*/

	public List<Account> getAllAccounts(Long bankId) {

		/*PreparedStatement prStatement = prepareStatement("SELECT * FROM " + getTableName() +" WHERE bankid=?;");

		try {
			prStatement.setLong(1, bankId);
			return formAccounts(prStatement);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}*/
		
		return em.createNamedQuery("Account.findByBankId", Account.class)
				.setParameter("bankId", bankId)
				.getResultList();
	}

	public List<Account> getAccountByFirstOrLastName(Long bankId, String name) throws SQLException {

		/*PreparedStatement prStatement = prepareStatement(
			"SELECT Account.* FROM Account " +
			"join Person on Account.personid = Person.id " +
			"WHERE bankid = ? AND " +
			"(Person.firstname = ? " +
			"OR Person.lastname = ?)");

		prStatement.setLong(1, bankId);
		prStatement.setString(2, name);
		prStatement.setString(3, name);

		return formAccounts(prStatement);*/
		
		return em.createNamedQuery("Account.findByByFirstOrLastName", Account.class)
				.setParameter("bankId", bankId)
				.setParameter("name", name)
				.getResultList();
	}

	public void update(Account account) throws SQLException {
		/*PreparedStatement prStatement = prepareStatement("UPDATE Account SET currency=?, amount=? WHERE id=?;");
		prStatement.setString(1, account.getAccountCurrency().name());
		prStatement.setDouble(2, account.getAmount());
		prStatement.setLong(3, account.getId());
		execute(prStatement);*/
		
		em.createNamedQuery("Account.updateCurrencyAmount", Account.class)
		.setParameter("id", account.getId())
		.setParameter("currency", account.getAccountCurrency().name())
		.setParameter("amount", account.getAmount())
		.executeUpdate();
		
		//TODO: update Person
	}

	@VisibleForTesting
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

}
