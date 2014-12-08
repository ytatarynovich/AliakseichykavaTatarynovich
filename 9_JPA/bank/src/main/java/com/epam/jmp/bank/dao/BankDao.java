package com.epam.jmp.bank.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.epam.jmp.bank.model.Bank;

/**
 * @author Hanna_Aliakseichykava
 */
public class BankDao extends AbstractDao {

	//private static final String NAME = "name";

	@Override
	protected String getTableName() {
		return "Bank";
	}

	/*public List<Bank> getAll() {

		List<Map<String, String>> rows = getAllRows();
		List<Bank> banks = new ArrayList<Bank>();

		for(Map<String, String> row : rows) {
			banks.add(new Bank(
					new Long(row.get(ID)),
					row.get(NAME)
				));
		}
		return banks;
	}*/

	public List<Bank> getAll() {
		return (List<Bank>) getAllRows();
	}

}
