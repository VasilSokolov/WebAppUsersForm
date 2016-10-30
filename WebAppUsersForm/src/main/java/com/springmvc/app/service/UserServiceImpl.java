package com.springmvc.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.springmvc.app.model.User;
import com.springmvc.app.model.UserCountry;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	// Dummy database. Initialize users with some dummy values.
	private static List<User> users;
	static{
		users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(), "pesho", "pesho@abv.bg", UserCountry.BULGARIA));
		users.add(new User(counter.incrementAndGet(), "abella", "abella@abv.bg", UserCountry.FRANCE));
		users.add(new User(counter.incrementAndGet(), "gosho", "gosho@abv.bg", UserCountry.GERMANY));
		users.add(new User(counter.incrementAndGet(), "maria91", "maria@abv.bg", UserCountry.ITALY));
		
	}	
	
	@Override
	public List<User> listAllUsers() {		
		return users;
	}
	
	@Override
	public User findById(Long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}

	@Override
	public void createUser(User user) {
		user.setId(counter.incrementAndGet());
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

}
