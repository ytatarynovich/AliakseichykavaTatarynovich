package com.epam.jmp.concurrency.menu.commands;

import org.apache.log4j.Logger;

import com.epam.jmp.concurrency.model.Account;
import com.epam.jmp.concurrency.model.Currency;
import com.epam.jmp.concurrency.services.AccountService;
import com.epam.jmp.concurrency.utils.ScannerUtils;

/**
 * @author Hanna_Aliakseichykava
 */
public class SetAcountAmountCommand extends AbstractBankCommand {

	private static final Logger log = Logger.getLogger(BankCommand.class);

	@Override
	public boolean execute(AccountService accountService) {

		boolean exit = false;

		Account account = finAccount(accountService);
		if(account == null) {
			return exit;
		}

		Currency currency = findCurrency();
		if(currency == null) {
			return exit;
		}

		log.info("Input amount:");
		double amount = ScannerUtils.scanDouble();
		if(amount < 0) {
			log.info("Account amount should be positive number. Transaction is interrupted.");
		}

		account.setAmount(currency, amount);
		log.info("Account is updated: " + account);

		return false;
	}
}
