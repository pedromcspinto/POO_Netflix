package UsersPackage;

public abstract class Plans implements InterfacePlans {
	
	public Plans() {
	}
	
	@Override
	public abstract int getDevices();

	@Override
	public abstract int getProfiles();
	
	@Override
	public abstract String getName();
		
}

