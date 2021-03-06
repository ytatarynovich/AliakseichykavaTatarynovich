package com.epam.jmp.concurrency.menu.commands;

import org.apache.log4j.Logger;

import com.epam.jmp.concurrency.model.Account;
import com.epam.jmp.concurrency.model.Currency;
import com.epam.jmp.concurrency.services.AccountService;
import com.epam.jmp.concurrency.utils.ScannerUtil;

/**
 * @author Hanna_Aliakseichykava
 */
public class SetAcountAmountCommand extends AbstractBankCommand {

	private static final Logger log = Logger.getLogger(BankCommand.class);

	@Override
	public boolean execute(AccountService accountService) {

		Account account = finAccount(accountService);

		Currency currency = findCurrency();

		log.info("Input amount:");
		double amount = ScannerUtil.scanDouble();
		if(amount < 0) {
			log.info("Account amount should be positive number. Transaction is interrupted.");
		}

		account.setAmount(currency, amount);
		log.info("Account is updated: " + account);

		return exit;
	}
}
