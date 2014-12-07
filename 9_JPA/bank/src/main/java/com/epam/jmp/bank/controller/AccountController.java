package com.epam.jmp.bank.controller;

import javax.ejb.EJB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.epam.jmp.bank.model.Account;
import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.services.AccountService;

import org.springframework.http.HttpStatus;

/**
 * @author Hanna_Aliakseichykava
 */
@Controller
@RequestMapping("/account")
public class AccountController {

	@EJB(mappedName="java:module/AccountServiceImpl")
	private AccountService service;

	@RequestMapping(value = "/update-account", method = RequestMethod.GET)
	public String getUpdateAccountPage() {
		return "update-account";
	}

	@RequestMapping(value = "/create-account", method = RequestMethod.GET)
	public String getCreateAccountPage() {
		return "create-account";
	}

	@RequestMapping(value = "/get-all-for-bank/{bankId}", method = RequestMethod.GET)
	@ResponseBody
	public String getAllAccountsForBank(@PathVariable("bankId") Long bankId) {
		return service.getBankAccountsAsJson(bankId);
	}

	private static final String ACCOUNT_ID = "accountid";
	private static final String CURRENCY = "currency";
	private static final String AMOUNT = "amount";

	@RequestMapping(value = "/get/{accountid}", method = RequestMethod.GET)
	@ResponseBody
	public String getAccount(@PathVariable(ACCOUNT_ID) Long accountid) {
		return service.getBankAccountAsJson(accountid);
	}

	@RequestMapping(value = "/update/{accountid}/{currency}/{amount}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void updateAccount(
			@PathVariable(ACCOUNT_ID) Long accountId,
			@PathVariable(CURRENCY) String currency,
			@PathVariable(AMOUNT) Double amount) {
		Account account = service.findAccountById(accountId);
		account.setAmount(Currency.findByName(currency), amount);
		service.updateAccount(account);
	}

	private static final String BANK_ID = "bankid";
	private static final String FIRST_NAME = "firstname";
	private static final String LAST_NAME = "lastname";

	@RequestMapping(value = "/create/{bankid}/{firstname}/{lastname}", method = RequestMethod.GET)
	@ResponseBody
	public String createAccount(
			@PathVariable(BANK_ID) Long bankId,
			@PathVariable(FIRST_NAME) String firstName,
			@PathVariable(LAST_NAME) String lastName) {

		Long id = service.createAccount(bankId, firstName, lastName);
		return String.valueOf(id);
	}
}
