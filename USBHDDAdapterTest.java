import java.util.Arrays;

public class USBHDDAdapterTest extends Assert {

	private Root root;
	private USBPort usbPort;

	@Before
	public void setUp() {
		usbPort = new USBPort();
		root = new Root(usbPort);
	}

	@Tst
	public void assembleIt() {
		HDD internalHDD = new HDD("1TB-Platte");
		USBHDDAdapter usbHDD = new USBHDDAdapter(internalHDD);
		boolean insertWorks;

		assertTrue(root.volumes().isEmpty());

		insertWorks = usbPort.insert(usbHDD);

		assertTrue(insertWorks);
		assertEquals(Arrays.asList("1TB-Platte"), root.volumes());

		// try to insert it a second time
		insertWorks = usbPort.insert(usbHDD);
		assertFalse(insertWorks);
	}
}
