
public abstract class AbstractVolume implements Volume {
	private String name;
	
	public AbstractVolume(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void accept(DeviceVisitor visitor) {
		visitor.visit(this);
	}
}
