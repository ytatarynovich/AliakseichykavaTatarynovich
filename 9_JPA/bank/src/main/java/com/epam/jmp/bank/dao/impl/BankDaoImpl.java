package com.epam.jmp.bank.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.jmp.bank.dao.BankDao;
import com.epam.jmp.bank.exceptions.BankNotFoundException;
import com.epam.jmp.bank.model.Bank;

@Component
public class BankDaoImpl extends AbstractDao implements BankDao{

	@Override
	public String getTableName() {
		return "Bank";
	}

	@Override
	public List<Bank> getAll() {
		return (List<Bank>) getAllRows();
	}

	@Override
	public Bank getById(Long id) {

		Bank bank = em.find(Bank.class, id);

		if(bank == null) {
			throw new BankNotFoundException(id);
		}

		return bank;
	}
}