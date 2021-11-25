package ExceptionPackage;

@SuppressWarnings("serial")
public class ShowNotAvailableException  extends Exception{

	public static final String MESSAGE = "ShowNotAvailable";
	public ShowNotAvailableException() {
		super(MESSAGE);
	}
}
