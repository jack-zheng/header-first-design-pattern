package chapter11;

public class SoldOutState implements State {
	GumballMachine gumballMachine;

	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("You can’t eject, you haven’t inserted a quarter yet");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("You can’t eject, you haven’t inserted a quarter yet");
	}

	@Override
	public void turnCrank() {
		System.out.println("You can’t eject, you haven’t inserted a quarter yet");
	}

	@Override
	public void dispense() {
		System.out.println("You can’t eject, you haven’t inserted a quarter yet");
	}

	@Override
	public String toString() {
		return "SoldOutState{" +
						"gumballMachine=" + gumballMachine +
						'}';
	}
}
