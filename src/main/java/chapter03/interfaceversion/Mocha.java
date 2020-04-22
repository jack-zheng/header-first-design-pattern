package chapter03.interfaceversion;

public class Mocha implements CondimentDec {
	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDesc() {
		return beverage.getDesc() + ", Mocha";
	}

	@Override
	public double cost() {
		return .5 + beverage.cost();
	}
}
