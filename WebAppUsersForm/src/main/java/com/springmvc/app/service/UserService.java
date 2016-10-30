package com.springmvc.app.service;

import java.util.List;

import com.springmvc.app.model.User;

public interface UserService {
	
	List<User> listAllUsers();
	
	void createUser(User user);
	
	void deleteUserById(Long id);
	
}
