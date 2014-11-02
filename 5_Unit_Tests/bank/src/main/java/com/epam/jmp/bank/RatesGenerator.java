package com.epam.jmp.bank;

import org.apache.log4j.Logger;

import com.epam.jmp.bank.services.CurrencyService;

/**
 * @author Hanna_Aliakseichykava
 */
public class RatesGenerator implements Runnable {

	private static final int DELAY = 10000;
	
	private static final Logger log = Logger.getLogger(RatesGenerator.class);

	private CurrencyService currencyService;

	public RatesGenerator(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	@Override
	public void run() {

		while(true) {
			currencyService.generateNewRates();
			//log.info("New rates are generated (in thread [" + Thread.currentThread().getName() + "])");
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				log.warn(e);
			}
		}
	}

}
