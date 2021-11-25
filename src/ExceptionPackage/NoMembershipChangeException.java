package ExceptionPackage;

@SuppressWarnings("serial")
public class NoMembershipChangeException extends Exception {
	
	public static final String MESSAGE = "No membership plan change.";
	
	public NoMembershipChangeException() {
		super(MESSAGE);
	}
}
