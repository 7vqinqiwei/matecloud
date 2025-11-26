package #{groupId}.core.common.exception;

/**
 * 认证异常
 *
 * @author #{version}
 */
public class AuthException extends Exception {

	private static final long serialVersionUID = 4973608667652183916L;

	public AuthException(String message) {
		super(message);
	}

}
