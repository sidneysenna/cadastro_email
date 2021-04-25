package br.tec.email.emailapp.service.inclusaocadastro;

public class InclusaoCadastroException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InclusaoCadastroException() {
	}

	public InclusaoCadastroException(String message) {
		super(message);
	}

	public InclusaoCadastroException(Throwable cause) {
		super(cause);
	}

	public InclusaoCadastroException(String message, Throwable cause) {
		super(message, cause);
	}

	public InclusaoCadastroException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
