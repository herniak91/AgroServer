package com.hwilliams.agroServer.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hwilliams.agroServer.controller.util.GenericJsonResponse;
import com.hwilliams.agroServer.service.exception.LoginException;

@ControllerAdvice
public class GlobanExceptionHandler {

	@ExceptionHandler(LoginException.class)
	@ResponseBody
	public GenericJsonResponse loginError(LoginException e){
		return GenericJsonResponse.createErrorResponse(e.getDescription());
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public GenericJsonResponse anyError(){
		return GenericJsonResponse.createErrorResponse("Ha ocurrido un error. Intentelo nuevamente mas tarde");
	}
	
}
