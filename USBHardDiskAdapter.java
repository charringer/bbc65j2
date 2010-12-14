
public class USBHardDiskAdapter<H extends HardDisk> implements USBDevice {
	private H hardDisc;

	/* the adapter will have hardDisc 
 	 * saved */
	public USBHardDiskAdapter(H hardDisc) {
		this.hardDisc = hardDisc;
	}

	/* calls visitor.visit with the hardDisc */
	public void accept(DeviceVisitor visitor) {
		visitor.visit(this.hardDisc);
	}
}
