package com.callawaygolf.service;

import com.callawaygolf.entity.LoginRequest;
import com.callawaygolf.entity.User;

public interface UserServiceInterface {

//	User register(User user);
//	User update(Long id, User user);
//	String delete (Long id);
//	User getUserById(Long id);
//	
//	User getUserByUserName(String userName);
//	User getUserByEmail(String email);
//	User creatingDefautUser();
	String findUser(LoginRequest loginRequest) ;
	//User findUser(String userName,String password );
	
	
}
