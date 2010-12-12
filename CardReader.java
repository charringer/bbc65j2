
public class CardReader<A extends Device> implements RootDevice {
	private Port<A> port = new Port<A>();
	
	public boolean insert(A a) {
		return port.insert(a);
	}
	
	public boolean eject() {
		return port.eject();
	}

	@Override
	public void accept(DeviceVisitor visitor) {
		port.accept(visitor);
	}

}
