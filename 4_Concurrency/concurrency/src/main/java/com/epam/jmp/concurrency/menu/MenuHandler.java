package com.epam.jmp.concurrency.menu;

import org.apache.log4j.Logger;

import com.epam.jmp.concurrency.model.Bank;
import com.epam.jmp.concurrency.services.AccountService;
import com.epam.jmp.concurrency.services.AccountServiceImpl;
import com.epam.jmp.concurrency.utils.ScannerUtils;

/**
 * @author Hanna_Aliakseichykava
 */
public class MenuHandler {

	private static final Logger log = Logger.getLogger(MenuHandler.class);

	private AccountService accountService;

	public void startMenu() {

		log.info("---- APP IS STARTED ----");

		Bank bank = new Bank("Don't worry, be happy");
		accountService = new AccountServiceImpl(bank);
		log.info("\n\n" + bank + " is created" + "\n");

		boolean exit = false;

		while (!exit) {

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

		BankAction action = BankAction.findByCode(actionCode);
		if(action == null) {
			log.info("Option [" + actionCode + "] is not supported, please, select another one from menu.");
		} else {
			exit = action.executeCommand(accountService);
		}

		return exit;
	}

}

