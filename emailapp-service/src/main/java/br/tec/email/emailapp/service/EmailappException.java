package br.tec.email.emailapp.service;

public class EmailappException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailappException() {
	}

	public EmailappException(String message) {
		super(message);
	}

	public EmailappException(Throwable cause) {
		super(cause);
	}

	public EmailappException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailappException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
