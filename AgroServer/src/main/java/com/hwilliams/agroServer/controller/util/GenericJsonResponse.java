package com.hwilliams.agroServer.controller.util;

public class GenericJsonResponse {
	public static final Integer RESP_OK = 0;
	public static final Integer RESP_ERROR = 1;
	
	private Integer code;
	private Object response;
	
	public static GenericJsonResponse createResponse(Object obj){
		GenericJsonResponse resp = new GenericJsonResponse();
		resp.setCode(RESP_OK);
		resp.setResponse(obj);
		return resp;
	}
	
	public static GenericJsonResponse createErrorResponse(Object obj){
		GenericJsonResponse resp = new GenericJsonResponse();
		resp.setCode(RESP_ERROR);
		resp.setResponse(obj);
		return resp;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}

}
