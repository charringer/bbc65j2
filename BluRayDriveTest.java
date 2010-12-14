
public class BluRayDriveTest extends Assert {
	
	private BluRayDrive bdd;
	private BluRayDisk bd;
	private DVD dvd;
	private CDROM cd;
	
	private boolean visitCalled;
	
	@Before
	public void setUp() {
		bdd = new BluRayDrive();
		bd = new BluRayDisk("bd");
		dvd = new DVD("dvd");
		cd = new CDROM("cd");
		visitCalled = false;
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
	
	@Tst
	public void accept_shouldCallVisitVolume() {
		bdd.insert(dvd);
		bdd.accept(new AbstractDeviceVisitor() {
			
			@Override
			public void visit(Volume vol) {
				assertEquals(dvd, vol);
				visitCalled = true;
			}
		});
		assertTrue(visitCalled);
	}
	
	@Tst
	public void accept_shouldNotCallVisitVolumeUnlessInserted() {
		bdd.accept(new AbstractDeviceVisitor() {
			
			@Override
			public void visit(Volume vol) {
				assertFalse(true);
			}
		});
	}

}
