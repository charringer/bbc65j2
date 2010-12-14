
public class CDROMDrive implements RootDevice {
	protected Port<? super CDROM> port = new Port<CDROM>();
	
        /* trys to insert "cdrom" into the drive
         * returns true if this was successful
         * false otherwise */
	public boolean insert(CDROM cdrom) {
		return port.insert(cdrom);
	}
	
	/* trys to eject the device currently in 
 	 * the drive 
	 * returns true if this was successful
	 * false otherwise */
	public boolean eject() {
		return port.eject();
	}
	
        /* implementation of the Visitor pattern
	 * therfore calls visit(this) on "visitor" */
	@Override
	public void accept(DeviceVisitor visitor) {
		port.accept(visitor);
	}
}
