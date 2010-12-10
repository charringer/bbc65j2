public class StorageInterface {

	/* a general StorageInterface DOES NOT accept every Device
	 */
	public boolean accept(Device foo) {
		return false;
	}
}
