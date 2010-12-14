
public interface Device {
	/* implementation of the Visitor pattern
	 * therfore should calls visit(this) on "visitor" */
	void accept(DeviceVisitor visitor);
}
