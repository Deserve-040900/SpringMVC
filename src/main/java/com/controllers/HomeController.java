package com.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("name", "Project Maven");
		return "index";
	}
	
	@RequestMapping(value = "/demo/{name}")
	public String test(Model model, @PathVariable(name = "name") String name) {
		model.addAttribute("name", name);
		return "index";
	}
	
	@RequestMapping(value = "/test")
	public String demo(Model model, @RequestParam(required = false) Map<String, String> params) {
		String fn = params.get("firstName");
		String ln = params.get("lastName");
		model.addAttribute("name", fn + ' ' + ln);
		return "index";
	}
}
