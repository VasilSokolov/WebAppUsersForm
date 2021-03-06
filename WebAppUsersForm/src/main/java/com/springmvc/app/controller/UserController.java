package com.springmvc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.springmvc.app.model.User;
import com.springmvc.app.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	//-------------------Retrieve All Users--------------------------------------------------------
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers(){
		List<User> users = userService.listAllUsers();
		if (users.isEmpty()) {			
			//You many decide to return HttpStatus.NOT_FOUND
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	//-------------------Create a User--------------------------------------------------------
    
    @RequestMapping(value = "/createUser/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {

        if (StringUtils.isEmpty(user.getUsername())) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        userService.createUser(user);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
    
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
  //------------------- Delete a User --------------------------------------------------------
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
 
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
