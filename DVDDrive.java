
public class DVDDrive extends CDROMDrive {
	protected Port<? super DVD> dvdPort;
	
	public DVDDrive() {
		port = dvdPort = new Port<DVD>();
	}
	
	public boolean insert(DVD dvd) {
		return dvdPort.insert(dvd);
	}
}
