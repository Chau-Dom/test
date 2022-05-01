package exception;

public class InvalidPhoneNumberException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String error;

	public InvalidPhoneNumberException(String error) {
		super();
		this.error = error;
	}

	@Override
	public String getMessage() {
		return this.error + "Không hợp lệ!";
	}

}
