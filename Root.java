import java.util.ArrayList;
import java.util.List;

public class Root implements Device {
	private RootDevice[] rootDevices;
	
	public Root(RootDevice... rootDevices) {
		this.rootDevices = rootDevices;
	}
	
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

	@Override
	public void accept(DeviceVisitor visitor) {
		for (Device dev : rootDevices) {
			dev.accept(visitor);
		}
	}

}
