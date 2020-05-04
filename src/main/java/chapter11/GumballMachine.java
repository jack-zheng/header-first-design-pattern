package chapter11;

public class GumballMachine implements GumballMachineRemote {
	private int count;
	private String location;
	private State state;

	public GumballMachine(String location, int count) {
		// other constructor code here
		this.location = location;
		this.count = count;
		this.state = new SoldOutState(this);
	}

	public String getLocation() {
		return location;
	}

	public int getCount() {
		return count;
	}

	public State getState() {
		return state;
	}
}
