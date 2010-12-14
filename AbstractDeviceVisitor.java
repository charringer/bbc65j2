
public abstract class AbstractDeviceVisitor implements DeviceVisitor {

	/* calles accept method of "device" 
	 * implements the Visitor pattern */
	@Override
	public void visit(Device device) {
		device.accept(this);
	}

}
