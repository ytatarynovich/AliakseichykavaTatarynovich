package com.epam.jmp.bank.services;

import java.util.List;

import com.epam.jmp.bank.dao.BankDao;
import com.epam.jmp.bank.model.Bank;
/**
 * @author Hanna_Aliakseichykava
 */
public class BankServiceImpl implements BankService{

	private BankDao bankDao;

	public BankServiceImpl() {
		this.bankDao = new BankDao();
	}

	@Override
	public List<Bank> getAllBanks() {
		return bankDao.getAll();
	}

}
