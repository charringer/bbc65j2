
public class USBHDDAdapter implements USBDevice {
	private HDD hdd;

	public USBHDDAdapter(HDD hdd) {
		this.hdd = hdd;
	}

	public void accept(DeviceVisitor visitor) {
		visitor.visit(this.hdd);
	}
}
