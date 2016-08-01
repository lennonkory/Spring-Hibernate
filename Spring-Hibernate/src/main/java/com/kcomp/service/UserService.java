package com.kcomp.service;

import com.kcomp.dao.UserDao;
import com.kcomp.model.User;

public interface UserService {

	boolean createUser(User user);
	User loadUserByUsername(String name);
	
	public UserDao getUserDao();
	public void setUserDao(UserDao userDao);
	
}
