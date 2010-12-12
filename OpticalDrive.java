
public class OpticalDrive extends DVDDrive {
	protected Port<? super OpticalDisk> optPort;
	
	public OpticalDrive() {
		port = dvdPort = optPort = new Port<OpticalDisk>();
	}
	
	public boolean insert(OpticalDisk opt) {
		return optPort.insert(opt);
	}
}
