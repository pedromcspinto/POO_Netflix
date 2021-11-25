package ExceptionPackage;

@SuppressWarnings("serial")
public class NoShowFoundException extends Exception {
	
	public static final String MESSAGE = "No show found.";
	public NoShowFoundException() {
		super(MESSAGE);
	}
	
}
