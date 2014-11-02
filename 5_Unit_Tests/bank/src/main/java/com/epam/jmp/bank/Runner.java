package com.epam.jmp.bank;

import com.epam.jmp.bank.menu.BankMenuHandler;
import com.epam.jmp.bank.model.Bank;
import com.epam.jmp.bank.services.BankService;
import com.epam.jmp.bank.services.BankServiceImpl;
import com.epam.jmp.bank.services.CurrencyService;
import com.epam.jmp.bank.services.CurrencyServiceImpl;

/**
 * @author Hanna_Aliakseichykava
 */
public class Runner {

	public static void main(String[] args) {

		CurrencyService currencyService = new CurrencyServiceImpl();

		Thread ratesGenerator = new Thread(new RatesGenerator(currencyService));
		ratesGenerator.setDaemon(true);
		ratesGenerator.start();

		BankService bankService = new BankServiceImpl();
		Bank bank = bankService.getAllBanks().get(0);

		new BankMenuHandler(currencyService, bank).startMenu();
	}

}

