
public class CardReader<A extends Device> implements RootDevice {
	private Port<A> port = new Port<A>();

        /* trys to insert "a" into the drive
	 * returns true if this was successful
	 * false otherwise */
	public boolean insert(A a) {
		return port.insert(a);
	}
	
        /* trys to eject the device currently in 
	 * the card reader
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
