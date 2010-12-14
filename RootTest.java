import java.util.Arrays;

public class RootTest extends Assert {

	private Root root;
	private HDD hdd;
	private SSD ssd;
	private USBPort usb1, usb2;
	private BluRayDrive bdd;
	private CDROMDrive cdd;
	private USBHardDiskAdapter<HardDisk> hdapt;
	private HDD hdd2;
	
	@Before
	public void setUp() {
		hdd = new HDD("hdd");
		ssd = new SSD("ssd");
		usb1 = new USBPort();
		usb2 = new USBPort();
		bdd = new BluRayDrive();
		cdd = new CDROMDrive();
		hdd2 = new HDD("foo");
		hdapt = new USBHardDiskAdapter<HardDisk>(hdd2);
		root = new Root(hdd, ssd, usb1, usb2, bdd, cdd);
	}
	
	@Tst
	public void volumes_shouldReturnVolumeNames() {
		usb1.insert(hdapt);
		bdd.insert(new CDROM("cd"));
		
		assertEquals(Arrays.asList("hdd", "ssd", "foo", "cd"),
				root.volumes());
	}
	
	@Tst
	public void volumes_shouldNotReturnRemovedVolumes() {
		cdd.insert(new CDROM("cd"));
		cdd.eject();
		
		assertEquals(Arrays.asList("hdd", "ssd"),
				root.volumes());
	}
}
