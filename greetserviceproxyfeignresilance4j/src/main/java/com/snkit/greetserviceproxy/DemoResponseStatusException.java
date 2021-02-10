package com.snkit.greetserviceproxy;

import feign.FeignException;

public class DemoResponseStatusException extends FeignException {
	
	private int code;
	private String message;
	public DemoResponseStatusException(int code, String message) {
		super(code,message);
		this.code = code;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
