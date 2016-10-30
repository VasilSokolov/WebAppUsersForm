package com.springmvc.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.springmvc.app.model.User;
import com.springmvc.app.model.UserCountry;

public class UserServiceImpl implements UserService{
	
	// Dummy database. Initialize users with some dummy values.
	private static List<User> users;
	{
		users = dummyUsers();
	}	
	
	@Override
	public List<User> listAllUsers() {		
		return users;
	}

	@Override
	public void createUser(User user) {
		user.setId(System.currentTimeMillis());
		users.add(user);
	}

	@Override
	public void deleteUserById(Long id) {
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}
	
	private static List<User> dummyUsers(){
		users = new ArrayList<User>();
		users.add(new User(1L, "pesho", "pesho@abv.bg", UserCountry.BULGARIA));
		users.add(new User(2L, "abella", "abella@abv.bg", UserCountry.FRANCE));
		users.add(new User(3L, "gosho", "gosho@abv.bg", UserCountry.BULGARIA));
		users.add(new User(4L, "maria91", "maria@abv.bg", UserCountry.ITALY));
		
		return users;
	}

}
