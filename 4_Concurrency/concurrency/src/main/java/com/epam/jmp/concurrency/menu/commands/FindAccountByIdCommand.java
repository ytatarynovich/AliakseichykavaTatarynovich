package com.epam.jmp.concurrency.menu.commands;

import com.epam.jmp.concurrency.services.AccountService;

/**
 * @author Hanna_Aliakseichykava
 */
public class FindAccountByIdCommand extends AbstractBankCommand {

	@Override
	public boolean execute(AccountService accountService) {

		finAccount(accountService);

		return false;
	}
}
