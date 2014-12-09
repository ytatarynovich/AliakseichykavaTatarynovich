package com.epam.jmp.bank.dao;

import java.util.List;

import com.epam.jmp.bank.model.Bank;

/**
 * @author Hanna_Aliakseichykava
 */
public class BankDao extends AbstractDao {

	@Override
	protected String getTableName() {
		return "Bank";
	}

	public List<Bank> getAll() {
		return (List<Bank>) getAllRows();
	}

}
