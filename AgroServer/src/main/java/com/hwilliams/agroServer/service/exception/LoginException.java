package com.hwilliams.agroServer.service.exception;

public class LoginException extends RuntimeException {
	private static final long serialVersionUID = 2934291352223163410L;
	private String errorCode;
	private String description;
	
	public LoginException(String description){
		this.description = description;
	}
	
	public LoginException(String code, String description){
		this.errorCode = code;
		this.description = description;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getDescription() {
		return description;
	}
	
}
