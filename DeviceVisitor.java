/* implementation of the Visitor pattern */
public interface DeviceVisitor {
	void visit(Device device);
	void visit(Volume vol);
}
