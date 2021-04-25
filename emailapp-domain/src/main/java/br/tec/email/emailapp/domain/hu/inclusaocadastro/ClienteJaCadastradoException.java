/**
 * 
 */
package br.tec.email.emailapp.domain.hu.inclusaocadastro;

/**
 * @author Sidney
 * Exception em caso de cliente ja cadastrado na base.
 *
 */
public class ClienteJaCadastradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ClienteJaCadastradoException() {
	}

	/**
	 * @param message
	 */
	public ClienteJaCadastradoException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ClienteJaCadastradoException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ClienteJaCadastradoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ClienteJaCadastradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
