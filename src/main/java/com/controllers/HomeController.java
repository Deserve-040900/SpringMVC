package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
