
public class Port<A extends Device> {
	private PortState<A> state;
	
	public boolean insert(A a) {
		return state.insert(a);
	}
	
	public boolean eject() {
		return state.eject();
	}

	public void accept(DeviceVisitor visitor) {
		state.accept(visitor);
	}
	
	private interface PortState<A> {
		boolean insert(A a);
		boolean eject();
		void accept(DeviceVisitor visitor);
	}
	
	private class DisconnectedState implements PortState<A> {

		@Override
		public boolean eject() {
			return false;
		}

		@Override
		public boolean insert(A a) {
			state = new ConnectedState(a);
			return true;
		}

		@Override
		public void accept(DeviceVisitor visitor) {}
	}
	
	private class ConnectedState implements PortState<A> {
		private A a;

		public ConnectedState(A a) {
			this.a = a;
		}

		@Override
		public boolean eject() {
			state = new DisconnectedState();
			return true;
		}

		@Override
		public boolean insert(A a) {
			return false;
		}

		@Override
		public void accept(DeviceVisitor visitor) {
			a.accept(visitor);
		}
		
	}
}
