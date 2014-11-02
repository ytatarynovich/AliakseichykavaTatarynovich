package com.epam.jmp.bank.menu;

import org.apache.log4j.Logger;

import com.epam.jmp.bank.model.Bank;
import com.epam.jmp.bank.services.AccountService;
import com.epam.jmp.bank.services.AccountServiceImpl;
import com.epam.jmp.bank.services.CurrencyService;
import com.epam.jmp.utils.ScannerUtils;

/**
 * @author Hanna_Aliakseichykava
 */
public class BankMenuHandler {

	private static final Logger log = Logger.getLogger(BankMenuHandler.class);

	private AccountService accountService;
	private CurrencyService currencyService;

	public BankMenuHandler(CurrencyService currencyService, Bank bank) {
		this.currencyService = currencyService;
		accountService = new AccountServiceImpl(bank);
		log.info("---------------");
		log.info("Bank: " + bank);
		log.info("---------------");
	}

	public void startMenu() {

		log.info("---- APP IS STARTED ----");

		boolean exit = false;

		while (!exit) {

			currencyService.refreshRates();
			log.info("Rates are refreshed (in thread [" + Thread.currentThread().getName() + "])");

			printMenu();

			int actionCode = ScannerUtils.scanInt();

			exit = handleAction(actionCode);
		}

		log.info("---- APP IS CLOSED ----");
	}

	private void printMenu() {

		log.info("\n\n------------ Select an option ------------");
		for(BankAction action : BankAction.values()) {
			log.info(action);
		}
		log.info("Your input:");
	}

	private boolean handleAction(int actionCode) {

		boolean exit = false;

		try {
			BankAction action = BankAction.findByCode(actionCode);
			exit = action.executeCommand(accountService);

		} catch(Exception e) {
			log.warn(e.getMessage());
		}

		return exit;
	}

}

