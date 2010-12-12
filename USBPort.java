
public class USBPort implements RootDevice {
	private Port<USBDevice> port = new Port<USBDevice>();
	
	public boolean insert(USBDevice dev) {
		return port.insert(dev);
	}
	
	public boolean eject() {
		return port.eject();
	}

	@Override
	public void accept(DeviceVisitor visitor) {
		port.accept(visitor);
	}

}
