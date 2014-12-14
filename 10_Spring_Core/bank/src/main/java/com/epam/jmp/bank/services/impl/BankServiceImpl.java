package com.epam.jmp.bank.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.jmp.bank.dao.BankDao;
import com.epam.jmp.bank.model.Bank;
import com.epam.jmp.bank.services.BankService;
import com.google.common.annotations.VisibleForTesting;
import com.google.gson.Gson;
/**
 * @author Hanna_Aliakseichykava
 */
@Service
public class BankServiceImpl implements BankService{

	@Autowired
	private BankDao bankDao;

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
	public void setDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}
}
