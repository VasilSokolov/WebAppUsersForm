package com.springmvc.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping
public class HomeController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home() {
				
		return "home";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String allUsers() {
		
		return "allUsers";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createUser() {
		
		return "createUser";
	}
	
}
