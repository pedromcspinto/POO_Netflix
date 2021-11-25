package ExceptionPackage;

@SuppressWarnings("serial")
public class ShowNotAvailableExceptions extends Exception {
	
	public static final String MESSAGE = "Show not available.";

	public ShowNotAvailableExceptions() {
		super(MESSAGE);
	}
}
