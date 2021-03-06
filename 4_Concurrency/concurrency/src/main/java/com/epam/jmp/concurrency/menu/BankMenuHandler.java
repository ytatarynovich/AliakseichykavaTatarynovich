package com.epam.jmp.concurrency.menu;

import org.apache.log4j.Logger;

import com.epam.jmp.concurrency.model.Bank;
import com.epam.jmp.concurrency.services.AccountService;
import com.epam.jmp.concurrency.services.AccountServiceImpl;
import com.epam.jmp.concurrency.services.CurrencyService;
import com.epam.jmp.concurrency.utils.ScannerUtil;

/**
 * @author Hanna_Aliakseichykava
 */
public class BankMenuHandler {

	private static final Logger log = Logger.getLogger(BankMenuHandler.class);

	private AccountService accountService;
	private CurrencyService currencyService;

	public BankMenuHandler(CurrencyService currencyService) {
		this.currencyService = currencyService;

		Bank bank = new Bank("Don't worry, be happy");
		accountService = new AccountServiceImpl(bank);
		log.info("\n\n" + bank + " is created" + "\n");
	}

	public void startMenu() {

		log.info("---- APP IS STARTED ----");

		boolean exit = false;

		while (!exit) {

			currencyService.refreshRates();
			log.info("Rates are refreshed (in thread [" + Thread.currentThread().getName() + "])");

			printMenu();

			int actionCode = ScannerUtil.scanInt();

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

