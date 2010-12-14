
public abstract class AbstractDeviceVisitor implements DeviceVisitor {

	@Override
	public void visit(Device device) {
		device.accept(this);
	}

}
