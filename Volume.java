
public interface Volume extends Device {
	String getName();
	
	// Port<A> calls volume.accept(visitor) and this calls visitor.visit(volume). 
	void accept(DeviceVisitor visitor);
}
