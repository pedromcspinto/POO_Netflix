package ExceptionPackage;



@SuppressWarnings("serial")
public class ClientLoginException extends Exception {
	
	public static final String MESSAGE = "Client already logged in.";
	
	public ClientLoginException() {
		super(MESSAGE);
	}
}
