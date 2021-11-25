package ExceptionPackage;

@SuppressWarnings("serial")
public class ShowNotExistsExceptions extends Exception {
	
	public static final String MESSAGE = "Show does not exist.";

	public ShowNotExistsExceptions() {
		super(MESSAGE);
	}
}
