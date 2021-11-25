package ExceptionPackage;

@SuppressWarnings("serial")
public class ExceedProfileException extends Exception{
	
	public static final String MESSAGE = "Not possible to add more profiles.";
	
	public ExceedProfileException() {
		super(MESSAGE);
	}
}
