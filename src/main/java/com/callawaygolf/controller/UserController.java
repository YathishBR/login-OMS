package com.callawaygolf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.callawaygolf.entity.LoginRequest;
import com.callawaygolf.entity.User;
import com.callawaygolf.exception.ControllerException;
import com.callawaygolf.service.UserServiceInterface;




@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceInterface service;
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginrequest) {
		System.out.println(loginrequest);
		String user="";
		try {
			user=service.findUser(loginrequest);
//			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			ControllerException ce = new ControllerException("Failed to login",
					"Something went wrong on Controller");
//		return new ResponseEntity<ControllerException>( ce,HttpStatus.BAD_REQUEST);
		}
		return user;
	
	}
}
