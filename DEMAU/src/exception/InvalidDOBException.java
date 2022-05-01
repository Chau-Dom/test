package exception;

public class InvalidDOBException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "không đúng định dạng [dd/MM/yyyy]";
	}
}
