package com.epam.jmp.concurrency.menu.commands;

import org.apache.log4j.Logger;

import com.epam.jmp.concurrency.services.AccountService;
import com.epam.jmp.concurrency.utils.ScannerUtils;

public class CreateAccountCommand implements BankCommand {

	private static final Logger log = Logger.getLogger(BankCommand.class);

	@Override
	public boolean execute(AccountService accountService) {
		log.info("Input client first name:");
		String firstName = ScannerUtils.scanStr();
		log.info("Input client last name:");
		String lastName = ScannerUtils.scanStr();

		if(firstName.equals("") || lastName.equals("")) {
			log.info("Client's first and last names should not be empty, try again.");
		} else {
			long accountId = accountService.createAccount(firstName, lastName);
			log.info("Account successfully created: ");
			log.info(accountService.findAccountById(accountId));
		}

		return false;
	}
}
