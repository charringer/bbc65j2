import java.util.ArrayList;
import java.util.List;

public class Root implements Device {
	private RootDevice[] rootDevices;
	
	/* adds RootDevices to the root*/
	public Root(RootDevice... rootDevices) {
		this.rootDevices = rootDevices;
	}
	
	/* returns a list of the names of all
	 * volumes bellow the root 
	 * creates the list by calling this.accept
	 * with an special AbstractDeviceVisitor */
	public List<String> volumes() {
		final List<String> names = new ArrayList<String>();
		accept(new AbstractDeviceVisitor() {
			
			@Override
			public void visit(Volume vol) {
				names.add(vol.getName());
			}
		});
		return names;
	}

	/* calls the accept method of ervery RootDevice
	 * with "visitor" */
	@Override
	public void accept(DeviceVisitor visitor) {
		for (Device dev : rootDevices) {
			dev.accept(visitor);
		}
	}

}
