package com.callawaygolf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class LoginRequest {
	@Id
	@Column(length = 10)
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
