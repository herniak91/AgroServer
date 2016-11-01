package com.hwilliams.agroServer.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hwilliams.agroServer.controller.util.GenericJsonResponse;
import com.hwilliams.agroServer.service.exception.LoginException;

@ControllerAdvice
public class GlobanExceptionHandler {
	private static final Logger logger = Logger.getLogger(GlobanExceptionHandler.class);

	@ExceptionHandler(LoginException.class)
	@ResponseBody
	public GenericJsonResponse loginError(LoginException e){
		logger.error("Error de login. " + e);
		return GenericJsonResponse.createErrorResponse(e.getDescription());
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public GenericJsonResponse anyError(Exception e){
		logger.error(e);
		return GenericJsonResponse.createErrorResponse("Ha ocurrido un error. Intentelo nuevamente mas tarde");
	}
	
}
