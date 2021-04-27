package br.tec.email.emailapp.domain.hu.inclusaocadastro;

public class EnderecoNaoExistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnderecoNaoExistenteException() {
	}

	public EnderecoNaoExistenteException(String message) {
		super(message);
	}

	public EnderecoNaoExistenteException(Throwable cause) {
		super(cause);
	}

	public EnderecoNaoExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public EnderecoNaoExistenteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
