
public class BluRayDrive extends DVDDrive {
	protected Port<? super BluRayDisk> optPort;
	
	public BluRayDrive() {
		port = dvdPort = optPort = new Port<BluRayDisk>();
	}
	
	/* trys to insert "opt" into the drive
	 * returns true if this was successful
	 * false otherwise */
	public boolean insert(BluRayDisk opt) {
		return optPort.insert(opt);
	}
}
