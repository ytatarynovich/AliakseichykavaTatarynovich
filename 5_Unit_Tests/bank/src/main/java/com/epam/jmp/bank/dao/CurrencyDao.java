package com.epam.jmp.bank.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.epam.jmp.bank.model.Currency;

public class CurrencyDao extends AbstractDao {

	private static final String CURRENCY_NAME = "currency";
	private static final String RATE = "rate";

	public CurrencyDao() {
		super();
	}

	public CurrencyDao(Properties props) {
		super(props);
	}

	@Override
	protected String getTableName() {
		return "currency";
	}

	public void synchronizeCurrencies() {
		List<Map<String, String>> rows = getAllRows();
		for(Map<String, String> row : rows) {
			Currency currency = Currency.findByName(row.get(CURRENCY_NAME));
			currency.setRate(new Double(row.get(RATE)));
		}
	}

	synchronized public void updateCurrency(String name, Double newRate) throws SQLException {
		PreparedStatement prStatement = prepareStatement("UPDATE Currency SET rate=? WHERE currency=?;");
		prStatement.setDouble(1, newRate);
		prStatement.setString(2, name);
		execute(prStatement);
	}

}
