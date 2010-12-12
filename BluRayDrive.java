
public class BluRayDrive extends DVDDrive {
	protected Port<? super BluRayDisk> optPort;
	
	public BluRayDrive() {
		port = dvdPort = optPort = new Port<BluRayDisk>();
	}
	
	public boolean insert(BluRayDisk opt) {
		return optPort.insert(opt);
	}
}
