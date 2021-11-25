package ExceptionPackage;



@SuppressWarnings("serial")
public class NoClientLoginException extends Exception {
	
	public static final String MESSAGE = "No client is logged in.";
	
	public NoClientLoginException() {
		super(MESSAGE);
	}
}
