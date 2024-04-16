package com.cucumberproject.exceptions;

public class InvalidBrowserNameError extends Error {
	
	String msg;
	public InvalidBrowserNameError(String msg) {
		this.msg=msg;
	}
	 
	public String getMessage() {
		return super.getMessage();
	}
}
