package com.epam.jmp.bank.menu.commands;

import org.apache.log4j.Logger;

import com.epam.jmp.bank.services.AccountService;
import com.epam.jmp.utils.ScannerUtils;

/**
 * @author Hanna_Aliakseichykava
 */
public class CreateAccountCommand extends AbstractBankCommand {

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

		return exit;
	}
}
