package com.epam.jmp.bank.menu.commands;

import org.apache.log4j.Logger;

import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.services.AccountService;

/**
 * @author Hanna_Aliakseichykava
 */
public class PrintAllAccountsCommand extends AbstractBankCommand {

	private static final Logger log = Logger.getLogger(BankCommand.class);

	@Override
	public boolean execute(AccountService accountService) {

		log.info("==== All Bank accounts ====");

		for(Account account : accountService.getAllAccounts()) {
			log.info(account);
		}

		log.info("===========================");

		return exit;
	}
}
