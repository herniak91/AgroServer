package com.hwilliams.agroServer.service.exception;

public class MaquinaException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5678454486627872741L;
	private String msg;
	
	public MaquinaException(String message){
		this.msg = message;
	}

	public String getMsg() {
		return msg;
	}

}
