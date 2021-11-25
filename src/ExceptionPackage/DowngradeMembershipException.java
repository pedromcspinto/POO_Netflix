package ExceptionPackage;

@SuppressWarnings("serial")
public class DowngradeMembershipException extends Exception {
	public static final String MESSAGE = "Cannot downgrade membership plan at the moment.";

	public DowngradeMembershipException() {
		super(MESSAGE);
	}
}
