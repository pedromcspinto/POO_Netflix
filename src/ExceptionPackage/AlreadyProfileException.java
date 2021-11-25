package ExceptionPackage;

@SuppressWarnings("serial")
public class AlreadyProfileException extends Exception {

	public static final String MESSAGE = "There is already a profile ";

	public AlreadyProfileException() {
		super(MESSAGE);
	}
}
