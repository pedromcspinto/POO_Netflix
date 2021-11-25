package UploadsPackage;

import java.util.List;

public class SeriesClass extends AbstractUploads implements InterfaceSeries {

	private static final String SPACE = "; ";
	private int nseasons;
	private int nepisodes;

	public SeriesClass(String title, String director, int nseasons, int nepisodes, String age, int release, String genre,
			List<String> cast) {
		super(title, director, age, release, genre, cast);
		this.nseasons = nseasons;
		this.nepisodes = nepisodes;
	}

	@Override
	public int getSeasons() {
		return nseasons;
	}
	
	@Override
	public int getEpisodes() {
		return nepisodes;
	}

	public String toString() {
		return getTitle() + SPACE + getDirector() + SPACE + getSeasons() + SPACE + getEpisodes() + SPACE + getAge()
				+ SPACE + getRelease() + SPACE + getGenre();
	}
}
