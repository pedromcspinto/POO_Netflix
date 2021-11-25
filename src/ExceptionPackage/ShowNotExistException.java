package ExceptionPackage;

@SuppressWarnings("serial")
public class ShowNotExistException extends Exception {
	
	public static final String MESSAGE = "Show does not exist.";
	public ShowNotExistException() {
		super(MESSAGE);
	}
}


