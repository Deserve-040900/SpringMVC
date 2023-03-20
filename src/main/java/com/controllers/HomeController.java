package com.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojos.user;

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
	
	@GetMapping("/login")
	public String loginView(Model model) {
		model.addAttribute("user", new user());
		return "login";
	}
	@PostMapping("/login")
	public String loginHandler(Model model, @ModelAttribute(value = "user") user users) {
		if (users.getUsername().equals("admin") && users.getPassword().equals("12345")) {
			model.addAttribute("msg", "SUCCESSFUL");
		} else { model.addAttribute("msg", "FAILED!!"); }
		return "login";
	}
	// http GET --> get resources (public) --> URL?...
	// http POST --> add resources (private) --> http BODY
	// http PUT --> update (the whole resources)
	// http PATCH --> update (a part of resources)
	// http DELETE --> delete resources
}
