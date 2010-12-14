
public class DVDDrive extends CDROMDrive {
	protected Port<? super DVD> dvdPort;
	
	public DVDDrive() {
		port = dvdPort = new Port<DVD>();
	}
	
	/* trys to insert "dvd" into the drive
	 * returns true if this was successful
	 * false otherwise */
	public boolean insert(DVD dvd) {
		return dvdPort.insert(dvd);
	}
}
