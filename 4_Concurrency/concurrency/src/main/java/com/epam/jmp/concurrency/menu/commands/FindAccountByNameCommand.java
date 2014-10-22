package com.epam.jmp.concurrency.menu.commands;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.jmp.concurrency.model.Account;
import com.epam.jmp.concurrency.services.AccountService;
import com.epam.jmp.concurrency.utils.ScannerUtils;

/**
 * @author Hanna_Aliakseichykava
 */
public class FindAccountByNameCommand extends AbstractBankCommand {
	
	private static final Logger log = Logger.getLogger(BankCommand.class);
	
	@Override
	public boolean execute(AccountService accountService) {

		log.info("Input first or last name:");
		String name = ScannerUtils.scanStr();

		List<Account> foundAccounts = accountService.findAccountByFirstOrLastName(name);
		if(foundAccounts.size() == 0) {
			log.info("There are no accounts for person with name [" + name + "]");
		} else {
			log.info("Accounts, found by name [" + name + "]:");
			for(Account account : foundAccounts) {
				log.info(account);
			}
		}

		return false;
	}

}
