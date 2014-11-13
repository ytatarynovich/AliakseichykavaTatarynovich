package com.epam.jmp.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.jmp.bank.services.CurrencyService;
import com.epam.jmp.bank.utils.CurrencyUtil;

/**
 * @author Hanna_Aliakseichykava
 */
@Controller
@RequestMapping("/currency")
public class CurrencyController {

	@Autowired
	private CurrencyService service;

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	@ResponseBody
	public String getAll(ModelMap model) {

		return service.getAllCurrenciesAsJson();
	}

	@RequestMapping(value = "/exchange/old/{oldCurrency}/new/{newCurrency}/amount/{amount}", method = RequestMethod.GET)
	@ResponseBody
	public String getAccount(
			@PathVariable("oldCurrency") String oldCurrency,
			@PathVariable("newCurrency") String newCurrency,
			@PathVariable("amount") Double amount) {

		return String.valueOf(CurrencyUtil.exchangeCurrency(amount, oldCurrency, newCurrency));
	}
}

