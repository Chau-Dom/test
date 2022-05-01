package exception;

public class InvalidFullNameException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String error;

	public InvalidFullNameException(String error) {
		super();
		this.error = error;
	}

	@Override
	public String getMessage() {
		return error + " có độ dài không phù hợp";
	}
}
