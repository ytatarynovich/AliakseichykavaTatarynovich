package com.epam.jmp.bank.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {
	
	protected static final Logger log = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getIndexPage(ModelMap model, java.security.Principal principal) {
		//model.addAttribute("user", principal);
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}

}
