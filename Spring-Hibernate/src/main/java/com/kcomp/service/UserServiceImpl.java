package com.kcomp.service;

import java.util.logging.Logger;

import com.kcomp.dao.UserDao;
import com.kcomp.model.User;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	private final static Logger log = Logger.getLogger(UserServiceImpl.class.getName());
	
	public boolean createUser(User user) {
		if (!userDao.checkAvailable(user.getName())) {
			return false;
		}
		
		try {
			userDao.save(user);
			log.info("User saved");
		} catch(Exception e) {
			log.severe("Could not save user");
			return false;
		}
		
		return true;
	}

	public User loadUserByUsername(String name) {
		return userDao.loadUserByName(name);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
