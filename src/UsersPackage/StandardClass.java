package UsersPackage;

public class StandardClass extends Plans{
	private static final int STANDARD_DEVICES = 2;
	private static final int STANDARD_PROFILES = 5;
	private static final String STANDARD= "Standard";
	
	public StandardClass() {
		super();

	}

	public int getDevices() {
		return STANDARD_DEVICES;
	}

	public int getProfiles() {
		return STANDARD_PROFILES;
	}

	public String getName() {
		return STANDARD;
	}
}
