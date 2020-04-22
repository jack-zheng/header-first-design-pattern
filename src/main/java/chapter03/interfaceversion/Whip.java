package chapter03.interfaceversion;

public class Whip implements CondimentDec {
	Beverage beverage;

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDesc() {
		return beverage.getDesc() + ", Whip";
	}

	@Override
	public double cost() {
		return .3 + beverage.cost();
	}
}
