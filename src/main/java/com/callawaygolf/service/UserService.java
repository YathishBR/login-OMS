package com.callawaygolf.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callawaygolf.entity.LoginRequest;
import com.callawaygolf.entity.User;
import com.callawaygolf.exception.InavalidCredentialException;
import com.callawaygolf.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	UserRepository userRepo;
	@Override
	public String findUser(LoginRequest loginRequest1) {
		
	List<User> loginRequestlist=	userRepo.findAll();
	List<User> loginCredentiallist =loginRequestlist.stream().filter(column->column.getUserName().equals(loginRequest1.getUserName()) && column.getPassword().equals(loginRequest1.getPassword()))
	.collect(Collectors.toList());
	User login=loginCredentiallist.get(0);

	if(loginCredentiallist.size()==1) {
		
		
		return login.getRole();
	}
	else {
		
		
		throw new InavalidCredentialException("Credentials not matched");
	}
//		System.out.println(loginRequest1);
//		LoginRequest loginRequest = loginRequest1;
//		String username = loginRequest.getUserName();
//		System.out.println("User name "+ username);
//		String password = loginRequest.getPassword();
//		
//		User user = userRepo.findByUserName(username);
//		//User user1=userRepo.findByPassword(password);
//		System.out.println(user);
//	//	User user1 =new User();
//		
//		if (username.equals(user.getUserName()) && password.equals(user.getPassword())) {
//			if ((user.getRole().equalsIgnoreCase("ROLE_ADMIN"))) {
//				
//			} else if ((user.getRole().equalsIgnoreCase("ROLE_USER"))) {
//				
//			} else {
//				// throw new CustomException("user is not exist in the database.");
//			}
//
//		}
//		
//
//		return user;
//	}
}
}