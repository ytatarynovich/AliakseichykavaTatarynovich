package com.epam.jmp.bank.menu.commands;

import org.apache.log4j.Logger;

import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.services.AccountService;
import com.epam.jmp.utils.ScannerUtils;

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
		double amount = ScannerUtils.scanDouble();
		if(amount < 0) {
			log.info("Account amount should be positive number. Transaction is interrupted.");
		}

		account.setAmount(currency, amount);
		log.info("Account is updated: " + account);

		return exit;
	}
}
