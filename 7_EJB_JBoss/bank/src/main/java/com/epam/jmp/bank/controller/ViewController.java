package com.epam.jmp.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ViewController {
	
	@RequestMapping
	public String getIndexPage() {
		return "home";
	}
	
	/*@RequestMapping(value = "/{view}", method = RequestMethod.GET)
	public String getPage(@PathVariable("view") String view) {
		return view;
	}*/

	@RequestMapping(value = "/all-currencies", method = RequestMethod.GET)
	public String getAllCurrenciesPage() {
		return "all-currencies";
	}

	@RequestMapping(value = "/update-account", method = RequestMethod.GET)
	public String getUpdateAccountPage() {
		return "update-account";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}

}
