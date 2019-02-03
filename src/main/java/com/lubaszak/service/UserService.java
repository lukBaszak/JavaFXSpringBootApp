package com.lubaszak.service;

import com.lubaszak.model.user.User;

public interface UserService extends GenericService<User> {

	boolean authenticate(String email, String password);
	
	User findByEmail(String email);


}
