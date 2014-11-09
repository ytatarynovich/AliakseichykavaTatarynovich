package com.epam.jmp.bank.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.jmp.bank.model.Currency;
import com.epam.jmp.bank.services.CurrencyService;
import com.google.gson.Gson;

/**
 * @author Hanna_Aliakseichykava
 */
@Controller
@RequestMapping("/currency")
public class CurrencyController {

	//private static final Logger log = Logger.getLogger(CurrencyController.class);

	@Autowired
	private CurrencyService service;

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	@ResponseBody
	public String getAll(ModelMap model) {

		//log.info("\n!!!Service: \n" + service);
		//model.addAttribute("currency", service.getAllCurrencies().get(0));
		//return "currencies";
		
		//Map<String, Object> map = new HashMap<String, Object>();
		//map.put("currencies",  service.getAllCurrencies());
		//return service.getAllCurrencies().get(0).toString();
		return new Gson().toJson(service.getAllCurrencies());
	}
	/*public List<Currency> getAll(ModelMap model) {

		//log.info("\n!!!Service: \n" + service);
		//model.addAttribute("currency", service.getAllCurrencies().get(0));
		//return "currencies";
		
		//Map<String, Object> map = new HashMap<String, Object>();
		//map.put("currencies",  service.getAllCurrencies());
		return service.getAllCurrencies();
	}*/


}

