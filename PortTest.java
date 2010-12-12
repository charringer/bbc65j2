
public class PortTest extends Assert {
	
	private Port<CDROM> port;
	private boolean visitCalled;
	private CDROM cdrom;
	
	@Before
	public void setUp() {
		port = new Port<CDROM>();
		visitCalled = false;
		cdrom = new CDROM("Beautiful Sunday");
	}
	
	@Tst
	public void eject_shouldFailOnEmptyPort() {
		assertFalse(port.eject());
	}
	
	@Tst
	public void eject_shouldWorkOnFullPort() {
		port.insert(cdrom);
		assertTrue(port.eject());
	}
	
	@Tst
	public void insert_shouldWorkOnEmptyPort() {
		assertTrue(port.insert(cdrom));
	}
	
	@Tst
	public void insert_shouldFailOnFullPort() {
		port.insert(cdrom);
		assertFalse(port.insert(cdrom));
	}

	@Tst
	public void accept_shouldCallVisit() {
		port.insert(cdrom);
		port.accept(new DeviceVisitor() {
			
			@Override
			public void visit(Volume vol) {}
			
			@Override
			public void visit(Device device) {
				visitCalled = true;
			}
		});
		assertTrue(visitCalled);
	}
	
}
