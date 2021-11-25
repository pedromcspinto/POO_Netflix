package ExceptionPackage;

@SuppressWarnings("serial")
public class ShowNotRecentException extends Exception {

	public static final String MESSAGE = "Can only rate recently seen shows.";
	
	public ShowNotRecentException() {
		super(MESSAGE);
	}
}
