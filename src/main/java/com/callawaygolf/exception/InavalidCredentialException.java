package com.callawaygolf.exception;

import lombok.Data;

@Data
public class InavalidCredentialException extends RuntimeException{

	String message;

	public InavalidCredentialException(String message) {
		super(message);
		
	}
	
}
