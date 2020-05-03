package chapter11;

public class GumballMachineTestDrive {
	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine("hangzhou", 3);
		GumballMonitor monitor = new GumballMonitor(gumballMachine);
		// rest of test code here
		monitor.report();
	}
}
