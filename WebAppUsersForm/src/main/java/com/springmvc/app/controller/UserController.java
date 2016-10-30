package com.springmvc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.app.model.User;
import com.springmvc.app.service.UserService;

@RestController(value = "/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//-------------------Retrieve All Users--------------------------------------------------------
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllAuthors(){
		List<User> authors = userService.listAllUsers();
		if (authors.isEmpty()) {
			
			//You many decide to return HttpStatus.NOT_FOUND
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(authors, HttpStatus.OK);
	}
}
