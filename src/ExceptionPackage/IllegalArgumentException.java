package ExceptionPackage;


@SuppressWarnings("serial")
public class IllegalArgumentException extends Exception {
	
	public static final String MESSAGE = "Unknown command.";
	
	public IllegalArgumentException() {
		super(MESSAGE);
	}
}
