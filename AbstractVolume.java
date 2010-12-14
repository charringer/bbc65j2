
public abstract class AbstractVolume implements Volume {
	private String name;
	
	/* saves "name" */
	public AbstractVolume(String name) {
		this.name = name;
	}

	/* returns saved "name" */
	@Override
	public String getName() {
		return name;
	}

	/* implementation of the Visitor pattern
	 * therfore calls visit(this) on "visitor" */
	@Override
	public void accept(DeviceVisitor visitor) {
		visitor.visit(this);
	}
}
