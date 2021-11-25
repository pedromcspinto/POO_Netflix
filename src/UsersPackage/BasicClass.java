package UsersPackage;

public class BasicClass extends Plans {
	private static final int BASIC_DEVICES = 1;
	private static final int BASIC_PROFILES = 2;
	private static final String BASIC= "Basic";

	public BasicClass() {
		super();

	}

	public int getDevices() {
		return BASIC_DEVICES;
	}

	
	public int getProfiles() {
		return BASIC_PROFILES;
	}

	public String getName() {
		return BASIC;
	}
	
	
}
