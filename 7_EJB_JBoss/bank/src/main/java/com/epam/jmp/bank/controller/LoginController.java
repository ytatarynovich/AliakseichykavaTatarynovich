package com.epam.jmp.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndexPage() {
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/j_spring_security_logout", method = RequestMethod.GET)
	public String logout() {
		//TODO: clear user
		return "home";
	}

}
