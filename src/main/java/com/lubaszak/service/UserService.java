package com.lubaszak.service;

import com.lubaszak.bean.User;

public interface UserService extends GenericService<User> {

	boolean authenticate(String email, String password);
	
	User findByEmail(String email);

	boolean checkAuthentication(String email, String password);
}
