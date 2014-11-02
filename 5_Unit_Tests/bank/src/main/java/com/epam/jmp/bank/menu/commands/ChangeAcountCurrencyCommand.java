package com.epam.jmp.bank.menu.commands;

import org.apache.log4j.Logger;

import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.services.AccountService;
import com.epam.jmp.bank.utils.CurrencyUtil;

/**
 * @author Hanna_Aliakseichykava
 */
public class ChangeAcountCurrencyCommand extends AbstractBankCommand {

	private static final Logger log = Logger.getLogger(BankCommand.class);

	@Override
	public boolean execute(AccountService accountService) {

		Account account = finAccount(accountService);

		Currency currency = findCurrency();

		double amountInNewCurrency = CurrencyUtil.exchangeCurrency(account.getAmount(), account.getAccountCurrency(), currency);
		account.setAmount(currency,  amountInNewCurrency);
		accountService.updateAccount(account);
		log.info("Account is updated: " + account);

		return exit;
	}
}
