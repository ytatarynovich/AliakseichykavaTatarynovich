package com.epam.jmp.bank.services;

import java.io.Serializable;

import javax.ejb.Local;

/**
 * @author Hanna_Aliakseichykava
 */
@Local
public interface BankService extends Serializable {

	public String getAllBanksAsJson();

}
