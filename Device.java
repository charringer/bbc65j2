
public interface Device {
	/* implementation of the Visitor pattern */
	void accept(DeviceVisitor visitor);
}
