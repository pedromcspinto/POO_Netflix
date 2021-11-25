package UploadsPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractUploads implements InterfaceUploads {

	private String title;
	private String director;
	private String age;
	private int release;
	private String genre;
	private List<Integer> rate;
	private List<String> cast;
	private int split;
	//private int lastRate;

	public AbstractUploads(String title, String director, String age, int release, String genre, List<String> cast) {
		this.title = title;
		this.director = director;
		this.age = age;
		this.release = release;
		this.genre = genre;
		this.cast = cast;
		rate = new ArrayList<Integer>();
		split = 0;
		//lastRate = 0;

	}

	@Override
	public Iterator<String> listCast() {
		return cast.iterator();
	}

	@Override
	public void Split() {
		String[] str = getAge().split("");
		if (str[0].equals("1")) {
			split = Integer.parseInt(str[0] + Integer.parseInt(str[1]));
		} else {
			split = Integer.parseInt(str[0]);
		}
	}

	@Override
	public int getRelease() {
		return release;
	}

	@Override
	public int getSplit() {
		return split;
	}

	@Override
	public float getRate() {
		int result = 0;
		if (rate.size() != 0) {
			for (int r = 0; r < rate.size(); r++) {
				result += rate.get(r);
			}
			return (float) result / rate.size();
		} else
			return 0;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getDirector() {
		return director;
	}

	@Override
	public String getAge() {
		return age;
	}

	@Override
	public String getGenre() {
		return genre;
	}

	@Override
	public void rate(int i) {
		rate.add(i);
	}

	/*@Override
	public float getPosUpload() {
		float pos = getRate() * 10;
		lastRate = pos;
		return pos;
	}*/

	/*@Override
	public int getLastRate() {
		return lastRate;
	}*/

	@Override
	public int compareTo(String title) {
		int compare = this.getTitle().compareTo(title);
		return compare;
	}

	/*@Override
	public int getRateSize() {
		return rate.size();
	}*/
	
	@Override
	public abstract String toString();

}
