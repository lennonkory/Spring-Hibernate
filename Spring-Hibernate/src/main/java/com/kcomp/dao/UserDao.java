package com.kcomp.dao;

import com.kcomp.model.User;

public interface UserDao extends GenericDao<User, Long>{
	
	boolean checkAvailable(String name);
	
	User loadUserByName(String name);

}
