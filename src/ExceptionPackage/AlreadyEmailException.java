package ExceptionPackage;



@SuppressWarnings("serial")
public class AlreadyEmailException extends Exception {
	
	public static final String MESSAGE = "There is another account with email";
	
	public AlreadyEmailException() {
		super(MESSAGE);
	}
}
