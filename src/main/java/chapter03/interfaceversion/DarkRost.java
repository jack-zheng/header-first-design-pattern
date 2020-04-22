package chapter03.interfaceversion;

public class DarkRost implements Beverage {
	@Override
	public String getDesc() {
		return "DarkRost";
	}

	@Override
	public double cost() {
		return 1.5;
	}
}
