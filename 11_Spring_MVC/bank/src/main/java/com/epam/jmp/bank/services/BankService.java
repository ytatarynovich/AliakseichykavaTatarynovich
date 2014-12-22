package com.epam.jmp.bank.services;

import java.util.Map;

/**
 * @author Hanna_Aliakseichykava
 */
public interface BankService {

	public String getAllBanksAsJson();

	public Map<String, String> getAllBanksMap();

}
