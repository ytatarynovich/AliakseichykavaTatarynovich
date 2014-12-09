package com.epam.jmp.bank.dao;

import java.util.List;

import com.epam.jmp.bank.model.Bank;

/**
 * @author Hanna_Aliakseichykava
 */
public interface BankDao {

	public List<Bank> getAll();

	public Bank getById(Long id);
}
