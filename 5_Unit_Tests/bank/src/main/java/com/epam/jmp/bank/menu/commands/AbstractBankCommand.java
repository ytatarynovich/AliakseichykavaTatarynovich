package com.epam.jmp.bank.menu.commands;

import org.apache.log4j.Logger;

import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.services.AccountService;
import com.epam.jmp.bank.utils.CurrencyUtil;
import com.epam.jmp.utils.ScannerUtils;

public abstract class AbstractBankCommand implements BankCommand {

	private static final Logger log = Logger.getLogger(BankCommand.class);

	protected boolean exit = false;

	public abstract boolean execute(AccountService accountService);

	protected Account finAccount(AccountService accountService) {

		log.info("Input account id: ");
		int id = ScannerUtils.scanInt();

		Account account = accountService.findAccountById(id);
		log.info(account);

		return account;
	}

	protected Currency findCurrency() {

		CurrencyUtil.printAllCurrencies();
		log.info("Select currency code: ");

		int currencyCode = ScannerUtils.scanInt();

		Currency currency = CurrencyUtil.findCurrencyByCode(currencyCode);
		log.info(currency);

		return currency;
	}

}
