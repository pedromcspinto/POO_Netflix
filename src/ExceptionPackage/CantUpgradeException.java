package ExceptionPackage;



@SuppressWarnings("serial")
public class CantUpgradeException extends Exception {
	
	public static final String MESSAGE = "Cannot downgrade membership plan at the moment.";
	
	public CantUpgradeException() {
		super(MESSAGE);
	}
}
