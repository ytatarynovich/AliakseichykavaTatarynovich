package com.epam.jmp.concurrency.menu.commands;

import org.apache.log4j.Logger;

import com.epam.jmp.concurrency.model.Account;
import com.epam.jmp.concurrency.services.AccountService;
import com.epam.jmp.concurrency.utils.ScannerUtils;

public class FindAccountByIdCommand implements BankCommand {
	
	private static final Logger log = Logger.getLogger(BankCommand.class);

	@Override
	public boolean execute(AccountService accountService) {

		log.info("Input account id: ");
		int id = ScannerUtils.scanInt();
		log.info("Results of search:");
		
		Account account = accountService.findAccountById(id);
		if(account == null) {
			log.info("Account with id [" + id + "] can not be found.");
		} else {
			log.info(account); 
		}

		return false;
	}
}
