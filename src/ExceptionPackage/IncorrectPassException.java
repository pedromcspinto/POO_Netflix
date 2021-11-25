package ExceptionPackage;



@SuppressWarnings("serial")
public class IncorrectPassException extends Exception {
	
	public static final String MESSAGE = "Wrong password.";
	
	public IncorrectPassException() {
		super(MESSAGE);
	}
}