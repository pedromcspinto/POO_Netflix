package UsersPackage;

import java.util.*;

public class Account implements InterfaceAccount {
	private String name;
	private String email;
	private String device;
	private String password;
	private List<String> devices;
	private List<String> connected;
	private String lastConnected;
	private List<InterfaceProfile> profiles;
	private InterfaceProfile selectedProfile;
	private InterfacePlans plans;
	private String oldPlan;
	private String typeOfPlan;

	public Account(String name, String email, String password, String device) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.device = device;
		devices = new ArrayList<String>();
		connected = new ArrayList<String>();
		lastConnected = null;
		profiles = new ArrayList<InterfaceProfile>();
		typeOfPlan = "Basic";
		selectedProfile = null;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getDevice() {
		return device;
	}

	@Override
	public int getNumDevices() {
		return devices.size();
	}

	@Override
	public int numConnectedDevices() {
		return connected.size();
	}

	@Override
	public void lastConnected(String dev) {
		lastConnected = dev;
	}

	@Override
	public String getLast() {
		return lastConnected;
	}

	@Override
	public int indexOfDevice(String dev) {
		int result = -1;
		for (int i = 0; i < getNumDevices(); i++)
			if (devices.get(i).equals(dev))
				result = i;
		return result;
	}

	@Override
	public int indexOfDevices(String dev) {
		int result = -1;
		for (int i = 0; i < getNumDevices(); i++)
			if (connected.get(i).equals(dev))
				result = i;
		return result;
	}

	@Override
	public int indexOfConnected(String dev) {
		int result = -1;
		for (int i = 0; i < numConnectedDevices(); i++)
			if (connected.get(i).equals(dev))
				result = i;
		return result;
	}

	@Override
	public boolean isConnected(String dev) {
		return indexOfConnected(dev) != -1;
	}

	@Override
	public void addDevice(String dev) {
		devices.add(new String(dev));
	}

	@Override
	public void connectDevice(String dev) {
		connected.add(new String(dev));
	}

	@Override
	public void disconnectDevice(String dev) {
		connected.remove(indexOfDevice(dev));
	}

	@Override
	public void addProfile(String name, String type, int age) {
		if (type.equals("NORMAL"))
			profiles.add(new Profile(name));
		else
			profiles.add(new Child(name, age));
	}

	@Override
	public int searchIndexOfProfile(String name) {
		int result = -1;
		for (int i = 0; i < profiles.size(); i++)
			if (profiles.get(i).getProfileName().equals(name))
				result = i;
		return result;
	}

	@Override
	public boolean hasProfile(String name) {
		return searchIndexOfProfile(name) != -1;
	}

	@Override
	public int getNumProfiles() {
		return profiles.size();
	}

	@Override
	public InterfaceProfile getProfile(String name) {
		return profiles.get(searchIndexOfProfile(name));
	}

	@Override
	public InterfaceProfile getSelectedProfile() {
		return selectedProfile;
	}

	@Override
	public void addPlan() {
		plans = new BasicClass();
	}

	@Override
	public InterfacePlans getPlan() {
		return plans;
	}

	@Override
	public void setPlan(String type) {
		if (type.equals("Basic")) {
			plans = new BasicClass();
			typeOfPlan = "Basic";
		}
		if (type.equals("Standard")) {
			plans = new StandardClass();
			typeOfPlan = "Standard";
		}
		if (type.equals("Premium")) {
			plans = new PremiumClass();
			typeOfPlan = "Premium";
		}
	}

	@Override
	public void planOld() {
		oldPlan = plans.getName();
	}

	@Override
	public String getOldPlan() {
		return oldPlan;
	}

	public String getTypeOfPlan() {
		return typeOfPlan;

	}

	@Override
	public void SelectProfile(InterfaceProfile p) {
		if (p instanceof ChildInterface) {
			selectedProfile = (ChildInterface) p;
		} else
			selectedProfile = p;
	}

	@Override
	public Iterator<InterfaceProfile> listProfiles() {
		return profiles.iterator();
	}

	@Override
	public Iterator<String> listDevices() {
		return connected.iterator();
	}

	@Override
	public void disconnectProfile() {
		selectedProfile = null;
	}

}
