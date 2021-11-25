package ExceptionPackage;

@SuppressWarnings("serial")
public class NoSelectedProfileException  extends Exception{

	public static final String MESSAGE = "No profile is selected.";
	public NoSelectedProfileException() {
		super(MESSAGE);
	}
}
