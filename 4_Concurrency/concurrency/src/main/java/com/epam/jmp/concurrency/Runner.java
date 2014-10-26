package com.epam.jmp.concurrency;

import com.epam.jmp.concurrency.menu.BankMenuHandler;
import com.epam.jmp.concurrency.services.CurrencyService;
import com.epam.jmp.concurrency.services.CurrencyServiceImpl;

/**
 * @author Hanna_Aliakseichykava
 */
public class Runner {

	public static void main(String[] args) {

		CurrencyService currencyService = new CurrencyServiceImpl();

		Thread ratesGenerator = new Thread(new RatesGenerator(currencyService));
		ratesGenerator.setDaemon(true);
		ratesGenerator.start();

		new BankMenuHandler(currencyService).startMenu();
	}

}

