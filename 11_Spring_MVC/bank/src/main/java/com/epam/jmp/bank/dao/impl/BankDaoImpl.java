package com.epam.jmp.bank.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.jmp.bank.dao.BankDao;
import com.epam.jmp.bank.exceptions.BankNotFoundException;
import com.epam.jmp.bank.model.Bank;

@Repository
public class BankDaoImpl extends AbstractDao implements BankDao{

	@Override
	public String getTableName() {
		return "Bank";
	}

	@Override
	public List getAll() {
		return getAllRows();
	}

	@Override
	public Bank getById(Long id) {

		Bank bank = getEntityManager().find(Bank.class, id);

		if(bank == null) {
			throw new BankNotFoundException(id);
		}

		return bank;
	}
}