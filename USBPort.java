
public class USBPort implements RootDevice {
	private Port<USBDevice> port = new Port<USBDevice>();

	/* trys to insert "dev" into the drive
	 * returns true if this was successful
	 * false otherwise */
	public boolean insert(USBDevice dev) {
		return port.insert(dev);
	}
	
	/* trys to eject the device pluged in 
	 * returns true if this was successful
	 * false otherwise */
	public boolean eject() {
		return port.eject();
	}

	/* implementation of the Visitor pattern */
	@Override
	public void accept(DeviceVisitor visitor) {
		port.accept(visitor);
	}

}
