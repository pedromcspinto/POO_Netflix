package ExceptionPackage;


@SuppressWarnings("serial")
public class AlreadyLoginException extends Exception {
	
	public static final String MESSAGE = "Another client is logged in.";
	
	public AlreadyLoginException() {
		super(MESSAGE);
	}
}
