package com.epam.jmp.bank.menu.commands;

import com.epam.jmp.bank.services.AccountService;

/**
 * @author Hanna_Aliakseichykava
 */
public interface BankCommand {

	/**
	 * returns the flag that indicates about app interrupting
	 */
	public boolean execute (AccountService accountService);
}
