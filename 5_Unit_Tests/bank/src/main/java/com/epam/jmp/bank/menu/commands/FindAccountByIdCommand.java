package com.epam.jmp.bank.menu.commands;

import com.epam.jmp.bank.services.AccountService;

/**
 * @author Hanna_Aliakseichykava
 */
public class FindAccountByIdCommand extends AbstractBankCommand {

	@Override
	public boolean execute(AccountService accountService) {

		finAccount(accountService);

		return exit;
	}
}
