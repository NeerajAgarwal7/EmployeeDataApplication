package com.mindtree.EmpInfoApp.exceptions;

public class UtilException extends AppExceptions{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UtilException() {
		super();
	}

	public UtilException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UtilException(String message, Throwable cause) {
		super(message, cause);
	}

	public UtilException(String message) {
		super(message);
	}

	public UtilException(Throwable cause) {
		super(cause);
	}

}
