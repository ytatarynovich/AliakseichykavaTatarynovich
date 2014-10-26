package com.epam.jmp.concurrency.menu.commands;

import org.apache.log4j.Logger;

import com.epam.jmp.concurrency.model.Currency;
import com.epam.jmp.concurrency.services.AccountService;
import com.epam.jmp.concurrency.utils.ScannerUtil;

/**
 * @author Hanna_Aliakseichykava
 */
public class ChangeExchangeRateCommand extends AbstractBankCommand {

	private static final Logger log = Logger.getLogger(BankCommand.class);

	@Override
	public boolean execute(AccountService accountService) {

		Currency currency = findCurrency();

		log.info("Input new exchange rate:");
		double newRate = ScannerUtil.scanDouble();
		if(newRate < 0) {
			log.info("Exchange rate should be positive number. Transaction is interrupted.");
		}else {
			currency.setRate(newRate);
		}

		return exit;
	}
}
