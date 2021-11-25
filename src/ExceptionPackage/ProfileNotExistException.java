package ExceptionPackage;

@SuppressWarnings("serial")
public class ProfileNotExistException extends Exception {
	
	public static final String MESSAGE = "Profile does not exist.";

	public ProfileNotExistException() {
		super(MESSAGE);
	}
}
