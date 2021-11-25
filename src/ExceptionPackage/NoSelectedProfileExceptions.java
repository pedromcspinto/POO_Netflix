package ExceptionPackage;

@SuppressWarnings("serial")
public class NoSelectedProfileExceptions extends Exception {
	
	public static final String MESSAGE = "No profile is selected.";
	
	public NoSelectedProfileExceptions() {
		super(MESSAGE);
	}
}