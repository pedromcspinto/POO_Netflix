package UploadsPackage;

import java.util.*;

public class FilmClass extends AbstractUploads implements InterfaceFilms {

	private static final String SPACE = "; ";
	private int duration;

	public FilmClass(String title, String director, int duration, String age, int release, String genre,
			List<String> cast) {
		super(title, director, age, release, genre, cast);
		this.duration = duration;
	}


	@Override
	public int getDuration() {
		return duration;
	}

	public String toString() {
		return getTitle() + SPACE + getDirector() + SPACE + getDuration() + SPACE + getAge() + SPACE + getRelease()
				+ SPACE + getGenre();
	}
}
