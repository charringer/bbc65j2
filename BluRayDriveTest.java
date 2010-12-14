
public class BluRayDriveTest extends Assert {
	
	private BluRayDrive bdd;
	private BluRayDisk bd;
	private DVD dvd;
	private CDROM cd;
	
	@Before
	public void setUp() {
		bdd = new BluRayDrive();
		bd = new BluRayDisk("bd");
		dvd = new DVD("dvd");
		cd = new CDROM("cd");
	}
	
	@Tst
	public void insert_shouldAcceptBD() {
		assertTrue(bdd.insert(bd));
	}
	
	@Tst
	public void insert_shouldAcceptDVD() {
		assertTrue(bdd.insert(dvd));
	}
	
	@Tst
	public void insert_shouldAcceptCDROM() {
		assertTrue(bdd.insert(cd));
	}
	
	@Tst
	public void insert_shouldNotInsertTwice() {
		bdd.insert(dvd);
		assertFalse(bdd.insert(bd));
	}
	
	@Tst
	public void eject_shouldEjectAfterInsert() {
		bdd.insert(dvd);
		assertTrue(bdd.eject());
	}
	
	@Tst
	public void eject_shouldNotEjectBeforeInsert() {
		assertFalse(bdd.eject());
	}
	
	@Tst
	public void eject_shouldNotEjectTwice() {
		bdd.insert(dvd);
		bdd.eject();
		assertFalse(bdd.eject());
	}

}
