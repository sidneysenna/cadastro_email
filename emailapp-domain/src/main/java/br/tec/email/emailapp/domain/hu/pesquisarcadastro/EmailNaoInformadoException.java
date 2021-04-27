package br.tec.email.emailapp.domain.hu.pesquisarcadastro;

public class EmailNaoInformadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9116426568770940661L;

	public EmailNaoInformadoException() {
	}

	public EmailNaoInformadoException(String message) {
		super(message);
	}

	public EmailNaoInformadoException(Throwable cause) {
		super(cause);
	}

	public EmailNaoInformadoException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailNaoInformadoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
