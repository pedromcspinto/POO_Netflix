package ExceptionPackage;



@SuppressWarnings("serial")
public class NoAccountException extends Exception {
	
	public static final String MESSAGE = "Account does not exist.";
	
	public NoAccountException() {
		super(MESSAGE);
	}
}