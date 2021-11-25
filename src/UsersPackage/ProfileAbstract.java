package UsersPackage;


import java.util.*;
import UploadsPackage.*;

public abstract class ProfileAbstract implements InterfaceProfile{
	private static final int LASTWATCHED = 10;
	private String name;
	List<InterfaceUploads> watched;
	List<InterfaceUploads> rated;
	List<Integer> rates;

	public  ProfileAbstract(String name) {
		this.name=name;
		watched = new ArrayList<>();
		rated= new ArrayList<>();
		rates= new ArrayList<>();
	}
	@Override
	public String getProfileName() {
		return name;
	}
	@Override
	public void Watch(InterfaceUploads u) {
		if(watched.size()<LASTWATCHED) {
			watched.add(0, u);
		}else {
			watched.remove(9);
			watched.add(0, u);
		}
	}
	@Override
	public boolean isEmptyWatch() {	
		return watched.isEmpty();
	}
	@Override
	public void rateFilm(InterfaceUploads u, int rate) {
		u.rate(rate);	
		rated.add(u);
		rates.add(rate);
	}	
	
	@Override
	public Iterator<InterfaceUploads> listLastWatched(){
		return watched.iterator();		
	}
	
	@Override
	public int getWatchSize() {
		return watched.size();
	}

	@Override
	public Iterator<InterfaceUploads> listRated() {
		return rated.iterator();
	}

	@Override
	public int getRateSize() {
		return rated.size();
	}

	@Override
	public boolean isEmptyRate() {
		return rated.isEmpty();
	}

	@Override
	public Iterator<Integer> listRates() {
		return rates.iterator();
	}
}
