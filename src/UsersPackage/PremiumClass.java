package UsersPackage;

public class PremiumClass extends Plans{
	private static final int PREMIUM_DEVICES = 4;
	private static final int PREMIUM_PROFILES = 5;
	private static final String PREMIUM= "Premium";
	
	public PremiumClass() {
		super();

	}

	public int getDevices() {
		return PREMIUM_DEVICES;
	}

	public int getProfiles() {
		return PREMIUM_PROFILES;
	}

	public String getName() {
		return PREMIUM;
	}
}
