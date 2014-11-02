package com.epam.jmp.bank.menu.commands;

import com.epam.jmp.bank.services.AccountService;

/**
 * @author Hanna_Aliakseichykava
 */
public class ExitCommand extends AbstractBankCommand {

	public ExitCommand() {
		this.exit = true;
	}

	@Override
	public boolean execute(AccountService accountService) {
		return exit;
	}
}
