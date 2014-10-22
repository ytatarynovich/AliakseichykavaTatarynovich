package com.epam.jmp.concurrency.menu.commands;

import com.epam.jmp.concurrency.services.AccountService;

/**
 * @author Hanna_Aliakseichykava
 */
public interface BankCommand {

	/**
	 * returns the flag that indicates about app interrupting
	 */
	public boolean execute (AccountService accountService);
}
