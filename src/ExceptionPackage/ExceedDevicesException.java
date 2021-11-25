package ExceptionPackage;



@SuppressWarnings("serial")
public class ExceedDevicesException extends Exception {
	
	public static final String MESSAGE = "Not possible to connect more devices.";
	
	public ExceedDevicesException() {
		super(MESSAGE);
	}
}