package com.epam.jmp.concurrency.menu.commands;

import org.apache.log4j.Logger;

import com.epam.jmp.concurrency.services.AccountService;
import com.epam.jmp.concurrency.utils.ScannerUtil;

/**
 * @author Hanna_Aliakseichykava
 */
public class CreateAccountCommand extends AbstractBankCommand {

	private static final Logger log = Logger.getLogger(BankCommand.class);

	@Override
	public boolean execute(AccountService accountService) {
		log.info("Input client first name:");
		String firstName = ScannerUtil.scanStr();
		log.info("Input client last name:");
		String lastName = ScannerUtil.scanStr();

		if(firstName.equals("") || lastName.equals("")) {
			log.info("Client's first and last names should not be empty, try again.");
		} else {
			long accountId = accountService.createAccount(firstName, lastName);
			log.info("Account successfully created: ");
			log.info(accountService.findAccountById(accountId));
		}

		return exit;
	}
}
