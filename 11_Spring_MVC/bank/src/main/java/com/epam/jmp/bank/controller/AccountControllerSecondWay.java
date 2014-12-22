package com.epam.jmp.bank.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.jmp.bank.model.dto.AccountDto;
import com.epam.jmp.bank.services.AccountService;
import com.epam.jmp.bank.services.BankService;

/**
 * @author Hanna_Aliakseichykava
 */
@Controller
@RequestMapping("/account")
public class AccountControllerSecondWay {

	protected static final Logger log = Logger.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;

	@Autowired
	private BankService bankService;

	private static final String BANKS = "banks";
	private final static String ACCOUNT_DTO = "accountDto";

	@RequestMapping(value = "/create-account-mvc", method = RequestMethod.GET)
	public String getCreateAccountSecondWayPage(ModelMap model) {
		model.put(ACCOUNT_DTO, new AccountDto());
		return "create-account-secondway";
	}

	@RequestMapping(value = "/createAccount.do")
	public String createAccount(@Valid AccountDto account, BindingResult result) {
		if (result.hasErrors()) {
			log.info("\nERROR: " + account + "\n");
			return "create-account-secondway";
		} else {
			log.info("\nSUCCESS\n");
			Long id = accountService.createAccount(account);
			return "update-account";
		}
	}

	@ModelAttribute(BANKS)
	Map<String, String> getAllBanks() {
		return bankService.getAllBanksMap();
	}

}
