package com.epam.jmp.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.jmp.bank.services.BankService;

/**
 * @author Hanna_Aliakseichykava
 */
@Controller
@RequestMapping("/bank")
public class BankController {

	@Autowired
	private BankService service;

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	@ResponseBody
	public String getAll() {
		return service.getAllBanksAsJson();
	}
}

