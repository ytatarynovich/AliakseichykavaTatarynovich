package com.epam.jmp.bank.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.epam.jmp.bank.dao.BankDao;
import com.epam.jmp.bank.model.Bank;
import com.google.common.annotations.VisibleForTesting;
import com.google.gson.Gson;
/**
 * @author Hanna_Aliakseichykava
 */
@Stateless
public class BankServiceImpl implements BankService{

	private static final long serialVersionUID = 3L;
	private BankDao bankDao;

	public BankServiceImpl() {
		this.bankDao = new BankDao();
	}

	private static final String ID = "id";
	private static final String NAME = "name";

	public String getAllBanksAsJson() {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for(Bank bank : bankDao.getAll()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put(ID, String.valueOf(bank.getId()));
			map.put(NAME, bank.getName());
			list.add(map);
		}
		return new Gson().toJson(list);
	}

	@VisibleForTesting
	void setDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}
}
