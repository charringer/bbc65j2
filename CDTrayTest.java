public class CDTrayTest extends Assert {

	private CDTray cdTray;
	private CD cd;
	private DVD dvd;
	private BlueRayDisc blueRayDisc;
	private CF1 cf1;

	@Before
	public void setUp() {
		cdTray = new CDTray();
		cd = new CD();
		dvd = new DVD();
		blueRayDisc = new BlueRayDisc();
		cf1 = new CF1();
	}

	@Tst
	public void accept_likesCDs() {
		assertTrue(cdTray.accept(cd));
	}

	@Tst
	public void accept_dislikesDVDsAndBlueRay() {
		assertFalse(cdTray.accept(dvd));
		assertFalse(cdTray.accept(blueRayDisc));
	}

	@Tst
	public void accept_dislikesWrongMedia() {
		assertFalse(cdTray.accept(cf1));
	}
}
