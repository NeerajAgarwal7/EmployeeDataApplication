package com.mindtree.EmpInfoApp.exceptions;

public class AppExceptions extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppExceptions() {
		super();
	}

	public AppExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AppExceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public AppExceptions(String message) {
		super(message);
	}

	public AppExceptions(Throwable cause) {
		super(cause);
	}
	
	

}
