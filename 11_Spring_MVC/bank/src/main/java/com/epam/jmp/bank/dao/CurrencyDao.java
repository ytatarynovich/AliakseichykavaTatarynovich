package com.epam.jmp.bank.dao;

import java.util.List;

import com.epam.jmp.bank.model.CurrencyRate;

public interface CurrencyDao {

	public List<CurrencyRate> getAll();

	public CurrencyRate findByName(String name);

	public void update(String name, Double newRate);

}
