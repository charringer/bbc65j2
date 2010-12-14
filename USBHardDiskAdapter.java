
public class USBHardDiskAdapter<H extends HardDisk> implements USBDevice {
	private H hardDisc;

	public USBHardDiskAdapter(H hardDisc) {
		this.hardDisc = hardDisc;
	}

	public void accept(DeviceVisitor visitor) {
		visitor.visit(this.hardDisc);
	}
}
