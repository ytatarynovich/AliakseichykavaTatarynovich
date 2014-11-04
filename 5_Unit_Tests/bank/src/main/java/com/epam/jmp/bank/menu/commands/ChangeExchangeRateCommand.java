package com.epam.jmp.bank.menu.commands;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.services.AccountService;
import com.epam.jmp.bank.services.CurrencyService;
import com.epam.jmp.bank.services.CurrencyServiceImpl;
import com.epam.jmp.utils.ScannerUtils;

/**
 * @author Hanna_Aliakseichykava
 */
public class ChangeExchangeRateCommand extends AbstractBankCommand {

	private static final Logger log = Logger.getLogger(BankCommand.class);
	
	private CurrencyService currencyService;

	public ChangeExchangeRateCommand() {
		this.currencyService = new CurrencyServiceImpl();
	}

	@Override
	public boolean execute(AccountService accountService) {

		Currency currency = findCurrency();

		log.info("Input new exchange rate:");
		double newRate = ScannerUtils.scanDouble();
		if(newRate < 0) {
			log.info("Exchange rate should be positive number. Transaction is interrupted.");
		}else {
			currency.setRate(newRate);
			currencyService.updateCurrency(currency);
		}

		return exit;
	}
}
