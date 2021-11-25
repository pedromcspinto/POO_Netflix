package Netflix;

import java.util.*;

import ExceptionPackage.*;
import UploadsPackage.*;
import UsersPackage.*;
import ComparatorsPackage.*;

public class NetflixClass implements InterfaceNetflix {

	private List<Account> account;
	private static final String BASIC = "Basic";
	private static final String STANDARD = "Standard";
	private static final String PREMIUM = "Premium";
	private SortedSet<InterfaceUploads> CompareByTitle;
	private SortedSet<InterfaceUploads> CompareByDate;
	private Map<String, SortedSet<InterfaceUploads>> title;
	private Map<String, SortedSet<InterfaceUploads>> genre;
	private Map<Integer, SortedSet<InterfaceUploads>> rating;
	private Map<String, SortedSet<InterfaceUploads>> actor;
	private List<Iterator<InterfaceUploads>> ratingAux;
	private InterfaceAccount activeAccount;
	private static final int RATE = 10;

	public NetflixClass() {
		account = new ArrayList<Account>();
		CompareByTitle = new TreeSet<>(new CompareByTitle());
		CompareByDate = new TreeSet<>(new CompareByDate());
		title = new HashMap<>();
		genre = new HashMap<>();
		rating = new TreeMap<>();
		actor = new HashMap<>();
		ratingAux = new ArrayList<>();
		activeAccount = null;
	}

	@Override
	public void addUpload(String title, String genre, InterfaceUploads t) {
		SortedSet<InterfaceUploads> cmpTitle = this.title.get(title);
		SortedSet<InterfaceUploads> cmpGenre = this.genre.get(genre);
		if (cmpTitle == null) {
			cmpTitle = new TreeSet<>(new CompareByTitle());
			this.title.put(title, cmpTitle);
		}
		if (cmpGenre == null) {
			cmpGenre = new TreeSet<>(new CompareByDate());
			this.genre.put(genre, cmpTitle);
		}
		cmpTitle.add(t);
		cmpGenre.add(t);
		CompareByTitle.add(t);
		CompareByDate.add(t);
	}

	@Override
	public void AuxListByNameMap(String director, List<String> cast, InterfaceUploads t) {
		for (int i = 0; i < cast.size(); i++) {
			String key = cast.get(i);
			SortedSet<InterfaceUploads> cmpActor = actor.get(key);
			if (cmpActor == null) {
				cmpActor = new TreeSet<>(new CompareByDate());
				actor.put(key, cmpActor);
			}
			SortedSet<InterfaceUploads> cmpDirector = actor.get(director);
			if (cmpDirector == null) {
				cmpDirector = new TreeSet<>(new CompareByDate());
				actor.put(director, cmpDirector);
			}
			cmpActor.add(t);
			cmpDirector.add(t);
		}
	}

	@Override
	public void RegistUser(String name, String email, String password, String device)
			throws AlreadyLoginException, AlreadyEmailException {
		if (isSomeoneLogedIn())
			throw new AlreadyLoginException();
		if (existsEmail(email))
			throw new AlreadyEmailException();
		account.add(new Account(name, email, password, device));
		InterfaceAccount u = objName(name);
		LogIn(u);
		u.addDevice(device);
		u.connectDevice(device);
		u.lastConnected(device);
		u.addPlan();
	}

	@Override
	public void login(InterfaceAccount p, String email, String password, String device) throws ClientLoginException,
			AlreadyLoginException, NoAccountException, IncorrectPassException, ExceedDevicesException {
		if (activeAccount != null && existsAccount(p) && isLogedIn(p))
			throw new ClientLoginException();
		if (isSomeoneLogedIn())
			throw new AlreadyLoginException();
		if (!existsEmail(email))
			throw new NoAccountException();
		if (!isPassword(p, password))
			throw new IncorrectPassException();
		if (!p.getLast().equals(device) && p.numConnectedDevices() == getTypeDevices(p)
				&& p.indexOfDevices(device) == -1)
			throw new ExceedDevicesException();
		if (!isConnected(p, device))
			p.connectDevice(device);
		p.lastConnected(device);
		LogIn(p);
	}

	@Override
	public void addProfile(String name, String type, int age)
			throws NoClientLoginException, AlreadyProfileException, ExceedProfileException {
		if (!isSomeoneLogedIn())
			throw new NoClientLoginException();
		if (activeAccount.hasProfile(name))
			throw new AlreadyProfileException();
		if (getTypeProfiles() == activeAccount.getNumProfiles())
			throw new ExceedProfileException();
		activeAccount.addProfile(name, type, age);
	}

	@Override
	public void selectProfile(String name) throws NoClientLoginException, ProfileNotExistException {
		if (!isSomeoneLogedIn())
			throw new NoClientLoginException();
		if (!activeAccount.hasProfile(name))
			throw new ProfileNotExistException();
		activeAccount.SelectProfile(activeAccount.getProfile(name));
	}

	@Override
	public void processMembership(String type)
			throws NoClientLoginException, NoMembershipChangeException, DowngradeMembershipException {
		if (!isSomeoneLogedIn())
			throw new NoClientLoginException();
		if (activeAccount.getPlan().getName().equals(type))
			throw new NoMembershipChangeException();
		if (!canChangePlan(type))
			throw new DowngradeMembershipException();
		activeAccount.planOld();
		activeAccount.setPlan(type);
	}

	@Override
	public void LogIn(InterfaceAccount a) {
		activeAccount = a;
	}

	@Override
	public boolean isLogedIn(InterfaceAccount a) {
		return activeAccount.getName().equals(a.getName());
	}

	@Override
	public String getActiveAccount() {
		return activeAccount.getName();
	}

	@Override
	public InterfaceAccount activeAccount() {
		return activeAccount;
	}

	@Override
	public int activeAccountAge() {
		ChildInterface c = null;
		if (activeAccount.getSelectedProfile() instanceof ChildInterface) {
			c = (ChildInterface) activeAccount.getSelectedProfile();
		}
		return c.getAge();
	}

	@Override
	public String getLastDevice() {
		if (activeAccount != null)
			return activeAccount.getLast();
		else
			return null;
	}

	@Override
	public void LogOut() throws NoClientLoginException {
		if (!isSomeoneLogedIn())
			throw new NoClientLoginException();
		activeAccount.disconnectProfile();
		activeAccount = null;
	}

	@Override
	public boolean isSomeoneLogedIn() {
		return activeAccount != null;
	}

	@Override
	public void connectDevice(String dev) {
		activeAccount.connectDevice(dev);
	}

	@Override
	public void disconnectDevice() throws NoClientLoginException {
		if (!isSomeoneLogedIn())
			throw new NoClientLoginException();
		String dev = activeAccount.getLast();
		activeAccount.disconnectDevice(dev);
	}

	@Override
	public void watch(String name) throws NoClientLoginException, NoSelectedProfileExceptions, ShowNotExistsExceptions,
			ShowNotAvailableExceptions {
		if (!isSomeoneLogedIn()) {
			throw new NoClientLoginException();
		}
		if (!isProfileSelected()) {
			throw new NoSelectedProfileExceptions();
		}
		if (!title.containsKey(name)) {
			throw new ShowNotExistsExceptions();
		}
		InterfaceUploads u = (InterfaceUploads) findUpload(name);
		if (activeAccount.getSelectedProfile() instanceof ChildInterface && activeAccountAge() < getUploadSplit(u)) {
			throw new ShowNotAvailableExceptions();
		}
		activeAccount.getSelectedProfile().Watch(u);
	}

	@Override
	public int getUploadSplit(InterfaceUploads u) {
		return u.getSplit();
	}

	@Override
	public InterfaceUploads findUpload(String name) {
		Iterator<InterfaceUploads> set = listByName();
		InterfaceUploads u = null;
		while (set.hasNext()) {
			u = set.next();
			if (u.compareTo(name) == 0) {
				break;
			}
		}
		return u;
	}

	@Override
	public boolean isProfileSelected() {
		return activeAccount.getSelectedProfile() != null;
	}

	@Override
	public void rate(String name, int rate) throws NoClientLoginException, NoSelectedProfileExceptions,
			ShowNotExistsExceptions, ShowNotRecentException, ShowAlreadyRatedException {
		if (!isSomeoneLogedIn()) {
			throw new NoClientLoginException();
		}
		if (!isProfileSelected()) {
			throw new NoSelectedProfileExceptions();
		}
		InterfaceProfile p = activeAccount.getSelectedProfile();
		if (!title.containsKey(name)) {
			throw new ShowNotExistsExceptions();
		}
		InterfaceUploads u = (InterfaceUploads) findUpload(name);
		if (!isRecentShow(u, p)) {
			throw new ShowNotRecentException();
		}
		if (showAlreadyRated(u, p)) {
			throw new ShowAlreadyRatedException();
		}
		rateAux(u, rate);
	}

	@Override
	public void rateAux(InterfaceUploads u, int rate) {
		InterfaceUploads l = u;
		if (l.getRate() > 0) {
			removeFilm(u);
		}
		activeAccount.getSelectedProfile().rateFilm(l, rate);
		int keyRate = (int) (l.getRate() * RATE);
		SortedSet<InterfaceUploads> cmpTitle = rating.get(keyRate);
		if (cmpTitle == null) {
			cmpTitle = new TreeSet<>(new CompareByTitle());
			rating.put(keyRate, cmpTitle);
		}
		cmpTitle.add(l);
	}

	@Override
	public boolean isRecentShow(InterfaceUploads u, InterfaceProfile p) {
		boolean isRecent = false;
		Iterator<InterfaceUploads> it = getWatchList(p);
		while (it.hasNext()) {
			InterfaceUploads up = it.next();
			if (up.equals(u)) {
				isRecent = true;
			}
		}
		return isRecent;
	}

	@Override
	public boolean showAlreadyRated(InterfaceUploads u, InterfaceProfile p) {
		boolean alreadyRated = false;
		Iterator<InterfaceUploads> it = getRateList(p);
		while (it.hasNext()) {
			InterfaceUploads up = it.next();
			if (up.equals(u)) {
				alreadyRated = true;
			}
		}
		return alreadyRated;
	}

	@Override
	public void removeFilm(InterfaceUploads u) {
		int keyRate = (int) (u.getRate() * RATE);
		SortedSet<InterfaceUploads> set = rating.get(keyRate);
		set.remove(u);
	}

	@Override
	public Iterator<InterfaceUploads> getWatchList(InterfaceProfile p) {
		return activeAccount.getProfile(p.getProfileName()).listLastWatched();
	}

	@Override
	public Iterator<InterfaceUploads> getRateList(InterfaceProfile p) {
		return activeAccount.getProfile(p.getProfileName()).listRated();
	}

	@Override
	public Iterator<Integer> getRate(InterfaceProfile p) {
		return activeAccount.getProfile(p.getProfileName()).listRates();
	}

	@Override
	public Iterator<InterfaceProfile> getProfiles() {
		return activeAccount.listProfiles();
	}

	@Override
	public Iterator<String> getDevices() {
		return activeAccount.listDevices();
	}

	@Override
	public void getTypeOfPlan() {
		activeAccount.getTypeOfPlan();
	}

	@Override
	public boolean existsAccount(InterfaceAccount a) {
		Iterator<Account> it = listAccounts();
		boolean result = false;
		while (it.hasNext()) {
			if (it.next() == a) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public Iterator<InterfaceUploads> listByName() {
		return CompareByTitle.iterator();
	}

	@Override
	public Iterator<InterfaceUploads> listByDate() {
		return CompareByDate.iterator();
	}

	@Override
	public void listByGenre(String genre)
			throws NoClientLoginException, NoSelectedProfileExceptions, NoShowFoundException {
		if (!isSomeoneLogedIn()) {
			throw new NoClientLoginException();
		}
		if (!isProfileSelected()) {
			throw new NoSelectedProfileExceptions();
		}
		if (!this.genre.containsKey(genre)) {
			throw new NoShowFoundException();
		}
	}

	@Override
	public Iterator<InterfaceUploads> iteratorListByGenre(String genero) {
		SortedSet<InterfaceUploads> set = genre.get(genero);
		Iterator<InterfaceUploads> it = set.iterator();
		return it;
	}

	@Override
	public Iterator<InterfaceUploads> iteratorListByActor(String name) {
		SortedSet<InterfaceUploads> set = actor.get(name);
		Iterator<InterfaceUploads> it = set.iterator();
		return it;
	}

	@Override
	public void listByName(String name)
			throws NoClientLoginException, NoSelectedProfileExceptions, NoShowFoundException {
		if (!isSomeoneLogedIn()) {
			throw new NoClientLoginException();
		}
		if (!isProfileSelected()) {
			throw new NoSelectedProfileExceptions();
		}
		if (!actor.containsKey(name)) {
			throw new NoShowFoundException();
		}
	}

	@Override
	public Iterator<Iterator<InterfaceUploads>> iteratorListByRating(int rate) {
		int rat = rate * RATE;
		for (int i = 50; i >= rat; i--) {
			SortedSet<InterfaceUploads> set = rating.get(i);
			if (set != null) {
				Iterator<InterfaceUploads> l = set.iterator();
				ratingAux.add(l);
			}
		}
		return ratingAux.iterator();
	}

	@Override
	public void clearAux() {
		ratingAux.clear();
	}

	@Override
	public void listByRating(int rate)
			throws NoClientLoginException, NoSelectedProfileExceptions, NoShowFoundException {
		if (!isSomeoneLogedIn()) {
			throw new NoClientLoginException();
		}
		if (!isProfileSelected()) {
			throw new NoSelectedProfileExceptions();
		}
		if (!existShow(rate)) {
			throw new NoShowFoundException();
		}
	}

	@Override
	public boolean existShow(int rate) {
		boolean exist = false;
		Set<Integer> it = rating.keySet();
		Iterator<Integer> it2 = it.iterator();
		while (it2.hasNext()) {
			Integer i = it2.next();
			if (i.equals(rate * RATE))
				exist = true;
		}
		return exist;
	}

	@Override
	public Iterator<String> listCast(InterfaceUploads t) {
		return t.listCast();
	}

	@Override
	public Iterator<Account> listAccounts() {
		return account.iterator();
	}

	@Override
	public int getNumAccounts() {
		return account.size();
	}

	@Override
	public int getTypeDevices(InterfaceAccount p) {
		return p.getPlan().getDevices();
	}

	@Override
	public boolean isConnected(InterfaceAccount p, String dev) {
		boolean result = false;
		if (p.isConnected(dev))
			result = true;
		return result;
	}

	@Override
	public int indexOfUser(String name) {
		int result = -1;
		for (int i = 0; i < getNumAccounts(); i++)
			if (account.get(i).getName().equals(name))
				result = i;
		return result;
	}

	@Override
	public int indexOfEmail(String email) {
		int result = -1;
		for (int i = 0; i < getNumAccounts(); i++)
			if (account.get(i).getEmail().equals(email))
				result = i;
		return result;
	}

	@Override
	public boolean existsEmail(String email) {
		return indexOfEmail(email) != -1;
	}

	@Override
	public boolean isPassword(InterfaceAccount u, String pass) {
		boolean result = false;
		if (u.getPassword().equals(pass))
			result = true;
		return result;
	}

	@Override
	public InterfaceAccount objName(String name) {
		InterfaceAccount u = account.get(indexOfUser(name));
		return u;
	}

	@Override
	public InterfaceAccount objEmail(String email) {
		InterfaceAccount u = account.get(indexOfEmail(email));
		return u;
	}

	@Override
	public int changePlanProfile(String type) {
		int result = 0;
		if (type.equals(BASIC))
			result = 2;
		if (type.equals(STANDARD))
			result = 5;
		if (type.equals(PREMIUM))
			result = 5;
		return result;
	}

	@Override
	public int changePlanDevices(String type) {
		int result = 0;
		if (type.equals(BASIC))
			result = 1;
		if (type.equals(STANDARD))
			result = 2;
		if (type.equals(PREMIUM))
			result = 4;
		return result;
	}

	@Override
	public boolean canChangePlan(String type) {
		boolean result = true;
		if (activeAccount.numConnectedDevices() > changePlanDevices(type)
				|| activeAccount.getNumProfiles() > changePlanProfile(type))
			result = false;
		return result;
	}

	@Override
	public int getTypeProfiles() {
		return activeAccount.getPlan().getProfiles();
	}

	@Override
	public void processInfoAccount() throws NoClientLoginException {
		if (!isSomeoneLogedIn())
			throw new NoClientLoginException();
	}
}
