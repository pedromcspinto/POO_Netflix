package ExceptionPackage;

@SuppressWarnings("serial")
public class ShowAlreadyRatedException extends Exception {

public static final String MESSAGE = "Show already rated.";
	
	public ShowAlreadyRatedException() {
		super(MESSAGE);
	}
}