
public class CDROMDrive implements RootDevice {
	protected Port<? super CDROM> port = new Port<CDROM>();
	
	public boolean insert(CDROM cdrom) {
		return port.insert(cdrom);
	}
	
	public boolean eject() {
		return port.eject();
	}

	@Override
	public void accept(DeviceVisitor visitor) {
		port.accept(visitor);
	}
}
