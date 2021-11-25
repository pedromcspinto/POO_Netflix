package Testing;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import UploadsPackage.FilmClass;
import UsersPackage.Profile;

class LastWatchedTest {

	private String a;
	private String b;
	private String c;
	private String d;
	private java.util.List<String> e;
	FilmClass u = new FilmClass(a, b, 1, c, 2, d, e);

	@Test
	void test() {
		String pipz = "Amigo";
		Profile pls = new Profile(pipz);
		pls.Watch(u);
		pls.Watch(u);
		pls.Watch(u);
		pls.Watch(u);
		pls.Watch(u);
		pls.Watch(u);
		pls.Watch(u);
		pls.Watch(u);
		pls.Watch(u);
		pls.Watch(u);
		pls.Watch(u);
		int opa = pls.getWatchSize();
		assertEquals(10, opa);
	}
}
