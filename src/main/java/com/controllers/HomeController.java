package com.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojos.User;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index(Model model) {
		List<String> cate = new ArrayList<>();
		cate.add("Mobile");
		cate.add("Tablet");
		cate.add("Desktop");
		cate.add("Laptop");
		model.addAttribute("name", "Project Maven");
		model.addAttribute("Category", cate);
		model.addAttribute("user", new User());
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
		model.addAttribute("user", new User());
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginHandler(Model model, @ModelAttribute(value = "user") User user) {
		if (user.getUsername().equals("admin") && user.getPassword().equals("12345")) {
			model.addAttribute("msg", "SUCCESSFUL");
		} 
		else { model.addAttribute("msg", "FAILED!!"); }
		return "login";
	}
	// http GET --> get resources (public) --> URL?...
	// http POST --> add resources (private) --> http BODY
	// http PUT --> update (the whole resources)
	// http PATCH --> update (a part of resources)
	// http DELETE --> delete resources
}
