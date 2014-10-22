package com.epam.jmp.concurrency.menu.commands;

import com.epam.jmp.concurrency.services.AccountService;

public class ExitCommand implements BankCommand {

	@Override
	public boolean execute(AccountService accountService) {
		return true;
	}
}
