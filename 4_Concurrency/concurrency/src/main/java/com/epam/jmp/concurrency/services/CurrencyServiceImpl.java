package com.epam.jmp.concurrency.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.jmp.concurrency.utils.CurrencyUtil;
import com.epam.jmp.concurrency.utils.FileUtil;

/**
 * @author Hanna_Aliakseichykava
 */
public class CurrencyServiceImpl implements CurrencyService {

	private static final Logger log = Logger.getLogger(CurrencyServiceImpl.class);

	private static final String DEFAULT_PATH = "currencies.txt";

	private static final int MIN_RATE = 1;
	private static final int MAX_RATE = 15000;

	@Override
	public synchronized void generateNewRates() {
		List<String> strCurrencies = CurrencyUtil.generateRandomRates(MIN_RATE, MAX_RATE);
		FileUtil.writeToFile(DEFAULT_PATH, strCurrencies);
	}

	@Override
	public synchronized void refreshRates() {
		if(FileUtil.isFileExists(DEFAULT_PATH)) {
			List<String> strCurrencies = FileUtil.readFile(DEFAULT_PATH);
			CurrencyUtil.updateCurrencies(strCurrencies);
		} else {
			log.info("There are no info to update rates.");
		}
	}
}
