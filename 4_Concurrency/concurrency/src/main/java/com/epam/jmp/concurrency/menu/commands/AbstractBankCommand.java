package com.epam.jmp.concurrency.menu.commands;

import org.apache.log4j.Logger;

import com.epam.jmp.concurrency.model.Account;
import com.epam.jmp.concurrency.model.Currency;
import com.epam.jmp.concurrency.services.AccountService;
import com.epam.jmp.concurrency.utils.CurrencyUtil;
import com.epam.jmp.concurrency.utils.ScannerUtil;

public abstract class AbstractBankCommand implements BankCommand {

	private static final Logger log = Logger.getLogger(BankCommand.class);

	protected boolean exit = false;

	public abstract boolean execute(AccountService accountService);

	protected Account finAccount(AccountService accountService) {

		log.info("Input account id: ");
		int id = ScannerUtil.scanInt();

		Account account = accountService.findAccountById(id);
		log.info(account);

		return account;
	}

	protected Currency findCurrency() {

		CurrencyUtil.printAllCurrencies();
		log.info("Select currency code: ");

		int currencyCode = ScannerUtil.scanInt();

		Currency currency = CurrencyUtil.findCurrencyByCode(currencyCode);
		log.info(currency);

		return currency;
	}

}
