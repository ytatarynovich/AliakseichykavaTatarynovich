package com.epam.jmp.concurrency.menu.commands;

import org.apache.log4j.Logger;

import com.epam.jmp.concurrency.model.Account;
import com.epam.jmp.concurrency.model.Currency;
import com.epam.jmp.concurrency.services.AccountService;
import com.epam.jmp.concurrency.utils.CurrencyUtil;
import com.epam.jmp.concurrency.utils.ScannerUtils;

public class SetAcountAmountCommand implements BankCommand {

	private static final Logger log = Logger.getLogger(BankCommand.class);

	@Override
	public boolean execute(AccountService accountService) {

		boolean exit = false;

		log.info("Input account id: ");
		int id = ScannerUtils.scanInt();

		Account account = accountService.findAccountById(id);
		if(account == null) {
			log.info("Account with id [" + id + "] can not be found. Transaction is interrupted.");
			return exit;
		}

		log.info("Select currency code: ");
		CurrencyUtil.printAllCurrencies();
		int currencyCode = ScannerUtils.scanInt();

		Currency currency = Currency.findByCode(currencyCode);
		if(currency == null) {
			log.info("Currency with code [" + currencyCode + "] can not be found. Transaction is interrupted.");
			return exit;
		}

		//TODO:

		return false;
	}
}
