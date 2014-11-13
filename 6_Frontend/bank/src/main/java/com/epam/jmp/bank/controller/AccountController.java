package com.epam.jmp.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.services.AccountService;

/**
 * @author Hanna_Aliakseichykava
 */
@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService service;

	@RequestMapping(value = "/get-all-for-bank/{bankId}", method = RequestMethod.GET)
	@ResponseBody
	public String getAllAccountsForBank(@PathVariable("bankId") Long bankId) {
		return service.getBankAccountsAsJson(bankId);
	}

	@RequestMapping(value = "/get/{accountId}", method = RequestMethod.GET)
	@ResponseBody
	public String getAccount(@PathVariable("accountId") Long accountId) {
		return service.getBankAccountAsJson(accountId);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateAccount(
			@ModelAttribute("accountid") Long accountId, 
			@ModelAttribute("amount") Double amount,
			@ModelAttribute("currency") String currency) {

		Account account = service.findAccountById(accountId);
		account.setAmount(Currency.findByName(currency), amount);
		service.updateAccount(account);
	}
}
